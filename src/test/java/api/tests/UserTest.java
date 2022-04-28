package api.tests;

import api.tests.config.CreateRequest;
import api.tests.models.request.launcher.LauncherBody;
import api.tests.models.request.listener.HttpListenerBody;
import api.tests.models.request.login.LoginBody;
import api.tests.models.response.grunt.ResponseGruntItem;
import api.tests.models.response.hostedfiles.ResponseHostedFilesItem;
import api.tests.service.AppEntryPoint;
import api.tests.service.RunCommandViaSsh;
import com.jcraft.jsch.JSchException;
import org.junit.jupiter.api.*;
import utils.testhelpers.TestHelper;

import java.io.*;
import java.util.Arrays;
import java.util.Base64;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserTest extends TestHelper {
    @Test
    @Order(1)
    public  void loginTest ()   {

        responseLogin = CreateRequest.post200(
                LoginBody.getInstance("admin", "123")
        );
        assertEquals(true, responseLogin.getSuccess());
    }

    @Test
    @Order(2)
    public  void createListenerTest ()  {
        responseHttpListener = CreateRequest.post200(
                HttpListenerBody.getInstance(responseLogin.getCovenantToken()),
                responseLogin.getCovenantToken()
        );
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

        File file = new File("src/test/resources/" + "GruntHTTP.exe");
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJhZG1pbiIsImp0aSI6ImFkYWM5ZjAwLThmNzAtYTFkYS03ZTYzLWUyNWVmNThjOGMzNSIsImh0dHA6Ly9zY2hlbWFzLnhtbHNvYXAub3JnL3dzLzIwMDUvMDUvaWRlbnRpdHkvY2xhaW1zL25hbWVpZGVudGlmaWVyIjoiZDZjMzRmNWMtZTNiYi00OTJhLWFjMmItYjczZjFiNTllYmUxIiwiaHR0cDovL3NjaGVtYXMubWljcm9zb2Z0LmNvbS93cy8yMDA4LzA2L2lkZW50aXR5L2NsYWltcy9yb2xlIjpbIlVzZXIiLCJBZG1pbmlzdHJhdG9yIl0sImV4cCI6MTY1OTc3Mzk0OCwiaXNzIjoiQ292ZW5hbnQiLCJhdWQiOiJDb3ZlbmFudCJ9.6ntjIYrco5uLTQP2zI5tBFSDK4xNgHleaAgyv1wfIcc";
//        ResponseHostedFiles responseHostedFiles = CreateRequest.get200(
//                responseLogin.getCovenantToken(),
//                responseHttpListener.getId());
        ResponseHostedFilesItem[] responseHostedFilesItems = CreateRequest.get200(
                token,
                24);
        ResponseHostedFilesItem responseHostedFilesItem = Arrays.stream(responseHostedFilesItems).findFirst().get();
        OutputStream os = new FileOutputStream(file);
        os.write(Base64.getDecoder().decode(responseHostedFilesItem.getContent().getBytes()));
        os.close();

    }

    @Test
    @Order(5)
    public  void transferFileTest () throws InterruptedException, IOException {
        AppEntryPoint.transferFile(responseLauncher.getLauncherString());
    }

    @Test
    @Order(6)
    public synchronized  void execLauncherFileTest () throws JSchException {
        RunCommandViaSsh.runCommand("C:\\test\\files\\GruntHTTP.exe", false);
    }
    @Test
    @Order(7)
    public synchronized  void verifyConnectionTest () throws InterruptedException {
        ResponseGruntItem[] responseGruntItems = CreateRequest.get200(responseLogin.getCovenantToken());
        for (ResponseGruntItem responseGruntItem: responseGruntItems) {
//            if (responseGruntItem.getListenerId() == responseHttpListener.getId() &&
            if (responseGruntItem.getListenerId() == 24 &&
            responseGruntItem.getUserName().equals("remote") && responseGruntItem.getStatus().equals("active"))
            {
                System.out.println("Connection successful!");
            }

        }
    }

    @Test
    @Order(8)
    public synchronized  void taskKillLauncherFileTest () throws JSchException {
        RunCommandViaSsh.runCommand("taskkill /IM GruntHTTP.exe /F");
    }

    @Test
    @Order(8)
    public synchronized  void deleteListenerTest () throws JSchException {
        CreateRequest.delete204(responseHttpListener.getId(), responseLogin.getCovenantToken());
    }

}
