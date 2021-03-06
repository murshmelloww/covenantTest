package test.api;

import test.config.ConfigurationManager;
import test.api.covenant.CreateRequest;
import test.api.covenant.models.request.launcher.LauncherBody;
import test.api.covenant.models.request.listener.HttpListenerBody;
import test.api.covenant.models.request.login.LoginBody;
import test.api.covenant.models.request.users.CreateUserBody;
import test.api.covenant.models.response.grunt.ResponseGruntItem;
import test.api.ssh.service.AppEntryPoint;
import test.api.ssh.service.RunCommand;
import com.jcraft.jsch.JSchException;
import org.junit.jupiter.api.*;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserTest extends TestHelper implements ConfigurationManager {

    @BeforeAll
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
    @Order(1)
    public  void loginTest ()   {

        responseLogin = CreateRequest.post200(
                LoginBody.getInstance(configuration.userName(), configuration.userPassword())
        );
        System.out.println("Login successful!");
        Assertions.assertEquals(true, responseLogin.getSuccess());
    }

    @Test
    @Order(2)
    public  void createListenerTest ()  {
        responseHttpListener = CreateRequest.post200(
                HttpListenerBody.getInstance(responseLogin.getCovenantToken()),
                responseLogin.getCovenantToken()
        );
        Assertions.assertEquals("active", responseHttpListener.getStatus());
        System.out.println("Listener activated!");
    }
    @Test
    @Order(3)
    public  void generateLauncherTest ()  {
        responseLauncher = CreateRequest.put200(
                responseLogin.getCovenantToken(),
                LauncherBody.getInstance(responseHttpListener.getId())
        );
        responseLauncher = CreateRequest.post200(
                responseLogin.getCovenantToken()
        );
    }

    @Test
    @Order(4)
    public  void downloadLauncherTest () throws IOException, InterruptedException {
        //for checking this test it is necessary to host a file using front system, and replace
        //responseHttpListener.getId() with listener Id

//        File file = new File("src/test/resources/" + "GruntHTTP.exe");
//        ResponseHostedFilesItem[] responseHostedFilesItems = CreateRequest.get200(
//                responseLogin.getCovenantToken(),
//                responseHttpListener.getId());
//        ResponseHostedFilesItem responseHostedFilesItem = Arrays.stream(responseHostedFilesItems).findFirst().get();
//        OutputStream os = new FileOutputStream(file);
//        os.write(Base64.getDecoder().decode(responseHostedFilesItem.getContent().getBytes()));
//        os.close();

        //this part will work if endpoint return a file

//        File file = new File("src/test/resources/" + "GruntHTTP.exe");
//        OutputStream os = new FileOutputStream(file);
//        System.out.println(CreateRequest.getFile200(responseLogin.getCovenantToken()).readAllBytes());
//        CreateRequest.getFile200(responseLogin.getCovenantToken()).transferTo(os);
//        os.close();
    }

    @Test
    @Order(5)
    public  void transferFileTest () throws IOException {
        AppEntryPoint.transferFile(responseLauncher.getLauncherString());
        System.out.println("File transferred!");
    }

    @Test
    @Order(6)
    public  void execLauncherFileTest () throws JSchException {
        RunCommand.runCommand("C:\\test\\files\\GruntHTTP.exe", false);
        System.out.println("File executed!");
    }
    @Test
    @Order(7)
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
    @Order(8)
    public  void taskKillLauncherFileTest () throws JSchException {
        RunCommand.runCommand("taskkill /IM GruntHTTP.exe /F");
        System.out.println("Processed killed!");
    }

    @Test
    @Order(9)
    public  void deleteListenerTest ()  {
        CreateRequest.deleteListener204(
                responseHttpListener.getId(),
                responseLogin.getCovenantToken());
        System.out.println("Listener deleted!");
    }

    @Test
    @Order(10)
    public  void deleteUserTest ()  {
        CreateRequest.deleteUser204(
                responseUsers.getId(),
                adminToken);
        System.out.println("User deleted!");
    }

}
