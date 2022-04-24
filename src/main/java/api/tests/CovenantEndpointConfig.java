package api.tests;

import api.tests.models.request.listener.HttpListenerBody;
import api.tests.models.request.login.LoginBody;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class CovenantEndpointConfig extends CovenantEndpointSpec {

    public static ValidatableResponse createLogin(LoginBody body) {

        return given()
                .spec(set())
                .body(body)
                .when()
                .post("/users/login")
                .then();

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
}
