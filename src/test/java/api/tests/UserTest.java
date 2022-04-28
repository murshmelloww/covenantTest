package api.tests;

import api.tests.config.CreateRequest;
import api.tests.models.request.launcher.LauncherBody;
import api.tests.models.request.listener.HttpListenerBody;
import api.tests.models.request.login.LoginBody;
import api.tests.models.request.users.CreateUserBody;
import api.tests.models.response.grunt.ResponseGruntItem;
import api.tests.service.ssh.AppEntryPoint;
import api.tests.service.ssh.RunCommand;
import com.jcraft.jsch.JSchException;
import org.junit.jupiter.api.*;
import utils.testhelpers.TestHelper;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserTest extends TestHelper {

    @BeforeAll
    public void createUser ()
    {
        responseLogin = CreateRequest.post200(
                LoginBody.getInstance("admin", "123")
        );
        adminToken = responseLogin.getCovenantToken();
        responseUsers =  CreateRequest.postUser201(
                CreateUserBody.getInstance("testUser", "123"),
                adminToken
        );
    }
    @Test
    @Order(1)
    public  void loginTest ()   {

        responseLogin = CreateRequest.post200(
                LoginBody.getInstance("testUser", "123")
        );
        System.out.println("Login successful!");
        assertEquals(true, responseLogin.getSuccess());
    }

    @Test
    @Order(2)
    public  void createListenerTest ()  {
        responseHttpListener = CreateRequest.post200(
                HttpListenerBody.getInstance(responseLogin.getCovenantToken()),
                responseLogin.getCovenantToken()
        );
        assertEquals("active", responseHttpListener.getStatus());
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
    public  void downloadLauncherTest () throws IOException {

//        File file = new File("src/test/resources/" + "GruntHTTP.exe");
//        ResponseHostedFilesItem[] responseHostedFilesItems = CreateRequest.get200(
//                responseLogin.getCovenantToken(),
//                618);// here is hard code, because I don't understand how to host file using api
//        ResponseHostedFilesItem responseHostedFilesItem = Arrays.stream(responseHostedFilesItems).findFirst().get();
//        OutputStream os = new FileOutputStream(file);
//        os.write(Base64.getDecoder().decode(responseHostedFilesItem.getContent().getBytes()));
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
    public  void verifyConnectionTest () throws InterruptedException {
        ResponseGruntItem[] responseGruntItems = CreateRequest.get200(responseLogin.getCovenantToken());
        for (ResponseGruntItem responseGruntItem: responseGruntItems) {
            if (responseGruntItem.getListenerId() == responseHttpListener.getId() &&
            responseGruntItem.getUserName().equals("remote") && responseGruntItem.getStatus().equals("active"))
            {
                System.out.println("Connection successful!");
            }
        }
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
