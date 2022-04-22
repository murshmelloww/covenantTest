package api.tests;

import api.tests.models.request.LoginBody;
import api.tests.models.response.ResponseLogin;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LoginTest {

    @Test
    public  void loginTest ()
    {
//        ResponseLogin responseLogin = CreateLoginPost.code200(
//                LoginBody.getInstance("admin", "123")
//        );
//        assertEquals(true, responseLogin.isSuccess());

        RequestSpecification spec = new RequestSpecBuilder().
                setBaseUri("https://127.0.0.1").
                setPort(7443).
                setBasePath("/api/users/login").
                setContentType(ContentType.JSON).
                build();
        String boby1 = "{\n" +
                "    \"password\": \"123\",\n" +
                "    \"userName\":\"admin\"\n" +
                "}";
        Response response =  given()
                .spec(spec)
                .body(boby1)
                .log().all()
                .when()
                .post()
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .extract().response();
        String str = response.toString();
        System.out.println(str);
    }
}
