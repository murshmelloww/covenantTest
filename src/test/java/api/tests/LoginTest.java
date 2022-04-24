package api.tests;

import api.tests.models.request.listener.HttpListenerBody;
import api.tests.models.request.login.LoginBody;
import api.tests.models.response.listener.ResponseHttpListener;
import api.tests.models.response.login.ResponseLogin;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import utils.testhelpers.TestHelper;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LoginTest extends TestHelper {

    String token = "";

    @BeforeAll
    public void startSessions() throws IOException {
        runCovenantDocker();
        runWindowsDocker();
        runHTTPserver();

    }

    @Test
    public  void loginTest () throws InterruptedException {
        LoginBody loginBody = LoginBody.getInstance("admin", "123");
        ResponseLogin responseLogin = CreatePost.code200(
                loginBody
        );
        TimeUnit.SECONDS.sleep(20);
        assertEquals(true, responseLogin.isSuccess());
        token = responseLogin.getCovenantToken();
    }

    @Test
    public  void createListenerTest ()  {
        HttpListenerBody httpListenerBody = HttpListenerBody.getInstance();
        ResponseHttpListener responseHttpListener =
                CreatePost.code200(httpListenerBody, token);
    }
    @Test
    public  void generateLauncherTest () throws InterruptedException {
        //create request body
        //send request
        //verify answer

    }

    @Test
    public  void downloadLauncherTest () throws InterruptedException {
        //create folder var/www/html
        //create request body
        //send request
        //download file on created folder

    }

    @Test
    public  void uploadLauncherFileTest () throws InterruptedException {

        downloadFileOnWindows();
    }



    @Test
    public  void execLauncherFileTest () throws InterruptedException {
        executeFileOnWindows();
    }
    @Test
    public  void verifyConnectionTest () throws InterruptedException {

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

}
