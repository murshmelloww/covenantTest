package test.ui;

import com.jcraft.jsch.JSchException;
import org.junit.jupiter.api.*;
import test.config.ConfigurationManager;
import test.api.covenant.CreateRequest;
import test.api.covenant.models.request.launcher.LauncherBody;
import test.api.covenant.models.request.listener.HttpListenerBody;
import test.api.covenant.models.request.login.LoginBody;
import test.api.covenant.models.request.users.CreateUserBody;
import test.api.covenant.models.response.grunt.ResponseGruntItem;
import test.api.ssh.service.AppEntryPoint;
import test.api.ssh.service.RunCommand;

import java.io.File;
import java.io.IOException;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FrontTest extends TestHelper implements ConfigurationManager {

    @BeforeAll
    public void configuration()
    {

        driver = configureDriver(driver);
        basePath = configuration.basePath();
    }

    @Test
    @Order(1)
    public void createUser ()
    {
        responseLogin = CreateRequest.post200(
                LoginBody.getInstance(configuration.adminName(), configuration.adminPassword()));
        adminToken = responseLogin.getCovenantToken();

        responseUsers =  CreateRequest.postUser201(
                CreateUserBody.getInstance(configuration.userName(), configuration.userPassword()),
                adminToken
        );
    }
    @Test
    @Order(2)
    public  void loginTest ()   {
        responseLogin = CreateRequest.post200(
                LoginBody.getInstance(configuration.userName(), configuration.userPassword())
        );
        System.out.println("Login successful!");
        Assertions.assertEquals(true, responseLogin.getSuccess());
    }

    @Test
    @Order(3)
    public  void createListenerTest ()  {
        responseHttpListener = CreateRequest.post200(
                HttpListenerBody.getInstance(responseLogin.getCovenantToken()),
                responseLogin.getCovenantToken()
        );
        Assertions.assertEquals("active", responseHttpListener.getStatus());
        System.out.println("Listener activated!");
    }
    @Test
    @Order(4)
    public  void generateLauncherTest ()  {
        responseLauncher = CreateRequest.put200(
                responseLogin.getCovenantToken(),
                LauncherBody.getInstance(responseHttpListener.getId())
        );
        responseLauncher = CreateRequest.post200(
                responseLogin.getCovenantToken()
        );
        Assertions.assertEquals("GruntHTTP.exe", responseLauncher.getLauncherString());
        System.out.println("Launcher generated!");
    }

    @Test
    @Order(5)
    public void downLoadFileTest() throws InterruptedException {

        driver.get(basePath + loginEndpoint);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs(configuration.userName(), configuration.userPassword());

        driver.get(basePath + launcherEndpoint);
        LauncherPage launcherPage = new LauncherPage(driver);
        launcherPage.downloadLauncher();
        System.out.println("Launcher downloaded!");
        Thread.sleep(10000);
    }

    @Test
    @Order(6)
    public  void transferFileTest () throws IOException, InterruptedException {
        AppEntryPoint.transferFile(responseLauncher.getLauncherString());
        Thread.sleep(10000);
        System.out.println("File transferred!");
    }

    @Test
    @Order(7)
    public  void execLauncherFileTest () throws JSchException, InterruptedException {
        RunCommand.runCommand("C:\\test\\files\\GruntHTTP.exe", false);
        Thread.sleep(10000);
        System.out.println("File executed!");
    }
    @Test
    @Order(8)
    public  void verifyConnectionTest () throws InterruptedException, JSchException {
        ResponseGruntItem[] responseGruntItems = CreateRequest.get200(responseLogin.getCovenantToken());
        Boolean gruntConnected = false;
        Integer count = 0;
        do {
            for (ResponseGruntItem responseGruntItem: responseGruntItems) {
                if (responseGruntItem.getListenerId() == responseHttpListener.getId() &&
                        responseGruntItem.getUserName().equals("remote") && responseGruntItem.getStatus().equals("active"))
                {
                    System.out.println("Connection successful!");
                    gruntConnected = true;
                }
            }
            count++;
            RunCommand.runCommand("C:\\test\\files\\GruntHTTP.exe", false);
        }
        while (!gruntConnected || count!=3);
    }

    @Test
    @Order(9)
    public  void taskKillLauncherFileTest () throws JSchException {
        RunCommand.runCommand("taskkill /IM GruntHTTP.exe /F");
        System.out.println("Processed killed!");
    }

    @Test
    @Order(10)
    public  void deleteListenerTest ()  {
        CreateRequest.deleteListener204(
                responseHttpListener.getId(),
                responseLogin.getCovenantToken());
        System.out.println("Listener deleted!");
    }

    @Test
    @Order(11)
    public  void deleteUserTest ()  {
        CreateRequest.deleteUser204(
                responseUsers.getId(),
                adminToken);
        System.out.println("User deleted!");
    }


    @AfterAll
    public void driverClose ()
    {
        File file = new File("src/test/resources/GruntHTTP.exe");
        if(file.delete())
            System.out.println("GruntHTTP.exe deleted");
        else
            System.out.println("GruntHTTP.exe not deleted!");

        driver.close();
    }
}
