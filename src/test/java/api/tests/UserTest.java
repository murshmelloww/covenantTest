package api.tests;

import api.tests.models.request.listener.HttpListenerBody;
import api.tests.models.request.login.LoginBody;
import api.tests.models.response.launcher.ResponseLauncher;
import api.tests.models.response.listener.ResponseHttpListener;
import api.tests.models.response.login.ResponseLogin;
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

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserTest extends TestHelper {

    String token = "";

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
                HttpListenerBody.getInstance(),
                responseLogin.getCovenantToken()
        );
    }
    @Test
    @Order(3)
    public  void generateLauncherTest () throws InterruptedException, IOException {
        responseLauncher = CreateRequest.post200(
                responseLogin.getCovenantToken()
        );
    }

    @Test
    @Order(4)
    public  void downloadLauncherTest () throws InterruptedException {
        downloadLauncher = CreateRequest.get200(
                responseLogin.getCovenantToken()
        );

    }

    @Test
    @Order(5)
    public  void hostFileTest () throws InterruptedException {
        downloadFileOnWindows();
    }

    @Test
    public  void execLauncherFileTest () throws InterruptedException {
        executeFileOnWindows();
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
