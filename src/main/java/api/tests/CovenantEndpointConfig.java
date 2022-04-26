package api.tests;

import api.tests.models.request.listener.HttpListenerBody;
import api.tests.models.request.login.LoginBody;
import io.restassured.response.ValidatableResponse;
import org.assertj.core.api.Java6StandardSoftAssertionsProvider;

import static io.restassured.RestAssured.given;

public class CovenantEndpointConfig extends CovenantEndpointSpec {

    public static ValidatableResponse createLogin(LoginBody body) {

        return given()
                .spec(set())
                .body(body)
                .when()
                .post("/users/login")
                .then()
                .contentType("application/json; charset=utf-8")
                .log().all();

    }

    public static ValidatableResponse createListener (HttpListenerBody body, String token) {

        return given()
                .spec(set())
                .body(body)
                .header("Authorization","Bearer " + token)
                .when()
                .post("listeners/http")
                .then();

    }

    public static ValidatableResponse createLauncher(String token) {
        return given()
                .spec(set())
                .header("Authorization","Bearer " + token)
                .when()
                .post("launchers/binary")
                .then();
    }

    public static ValidatableResponse getLauncher(String token) {
        return given()
                .spec(set())
                .header("Authorization","Bearer " + token)
                .when()
                .get("launchers/binary")
                .then();
    }
}
