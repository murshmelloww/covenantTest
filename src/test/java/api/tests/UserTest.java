package api.tests;

import api.tests.models.request.launcher.LauncherBody;
import api.tests.models.request.listener.HttpListenerBody;
import api.tests.models.request.login.LoginBody;
import api.tests.models.response.hostedfiles.ResponseHostedFiles;
import api.tests.models.response.hostedfiles.ResponseHostedFilesItem;
import api.tests.models.response.launcher.ResponseLauncher;
import api.tests.models.response.listener.ResponseHttpListener;
import api.tests.models.response.login.ResponseLogin;
import api.tests.service.AppEntryPoint;
import api.tests.service.RunCommandViaSsh;
import com.jcraft.jsch.JSchException;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.*;
import utils.testhelpers.TestHelper;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserTest extends TestHelper {
    @BeforeAll
    public void startSessions() throws IOException {
        runCovenantDocker();
        runWindowsDocker();
        runHTTPserver();

    }

    @Test
    @Order(1)
    public  void loginTest () throws InterruptedException, IOException {

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

//        File file = new File("src/test/resources/" + "GruntHTTP.exe");
//        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJhZG1pbiIsImp0aSI6IjQxNTJmNTZjLTA2MTUtZDEyZS05Yjg0LTQyMTc5ZDRkYmZiMCIsImh0dHA6Ly9zY2hlbWFzLnhtbHNvYXAub3JnL3dzLzIwMDUvMDUvaWRlbnRpdHkvY2xhaW1zL25hbWVpZGVudGlmaWVyIjoiZjE5MzAxNWUtYjVjNy00NjRlLWJmZjgtZjBlMDc1NzNjMGIyIiwiaHR0cDovL3NjaGVtYXMubWljcm9zb2Z0LmNvbS93cy8yMDA4LzA2L2lkZW50aXR5L2NsYWltcy9yb2xlIjpbIlVzZXIiLCJBZG1pbmlzdHJhdG9yIl0sImV4cCI6MTY1OTcwNDkzMiwiaXNzIjoiQ292ZW5hbnQiLCJhdWQiOiJDb3ZlbmFudCJ9.iE6841fb2mcToNJGFGzaiA8wksd1pziUAVi5BFGxaUU";
////        ResponseHostedFiles responseHostedFiles = CreateRequest.get200(
////                responseLogin.getCovenantToken(),
////                responseHttpListener.getId());
//        ResponseHostedFilesItem[] responseHostedFilesItems = CreateRequest.get200(
//                token,
//                616);
//        ResponseHostedFilesItem responseHostedFilesItem = Arrays.stream(responseHostedFilesItems).findFirst().get();
//        OutputStream os = new FileOutputStream(file);
//        os.write(responseHostedFilesItem.getContent().getBytes(StandardCharsets.UTF_8));
//        os.close();

    }

    @Test
    @Order(5)
    public  void transferFileTest () throws InterruptedException, IOException {
        AppEntryPoint.transferFile(responseLauncher.getLauncherString());
    }

    @Test
    public  void execLauncherFileTest () throws JSchException {
        RunCommandViaSsh.runCommand("C:\\test\\files\\GruntHTTP.exe");
    }
    @Test
    public  void verifyConnectionTest () throws InterruptedException {
        //check grunts list
        checkConnectionOnWindows();
    }

    @AfterAll
    public void terminateAll() throws IOException {
        stopHTTPserver();
        stopCovenantDocker();
        stopWindowsDocker();
    }


    public void kjn ()
    {
//        RequestSpecification spec = new RequestSpecBuilder().
//                setBaseUri("https://127.0.0.1").
//                setPort(7443).
//                setBasePath("/api/users/login").
//                setContentType(ContentType.JSON).
//                build();
//        String boby1 = "{\n" +
//                "    \"password\": \"123\",\n" +
//                "    \"userName\":\"admin\"\n" +
//                "}";
//        Response response =  given()
//                .spec(spec)
//                .body(boby1)
//                .when()
//                .post()
//                .then()
//                .log().all()
//                .extract().response();
//        String str = response.toString();
//        System.out.println(str);
    }

    public static void downloadFile(URL url, String outputFileName) throws IOException
    {
        try (InputStream in = url.openStream();
             ReadableByteChannel rbc = Channels.newChannel(in);
             FileOutputStream fos = new FileOutputStream(outputFileName)) {
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        }
    }

}
