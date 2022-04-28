package api.tests.config;

import api.tests.models.request.launcher.LauncherBody;
import api.tests.models.request.listener.HttpListenerBody;
import api.tests.models.request.login.LoginBody;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.assertj.core.api.Java6StandardSoftAssertionsProvider;

import static io.restassured.RestAssured.given;

public class CovenantEndpointConfig extends CovenantEndpointSpec {

    public static ValidatableResponse createLogin(LoginBody body) {

        return given()
                .spec(set())
                .contentType(ContentType.JSON)
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
                .contentType(ContentType.JSON)
                .body(body)
                .header("Authorization","Bearer " + token)
                .when()
                .post("listeners/http")
                .then();

    }

    public static ValidatableResponse createLauncher(String token) {
        return given()
                .spec(set())
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer " + token)
                .when()
                .post("launchers/binary")
                .then();
    }

    public static ValidatableResponse createHostedFiles(String token, Integer listenerId) {
        return given()
                .spec(set())
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer " + token)
                .when()
                .get("listeners/"+ listenerId +"/hostedfiles")
                .then();
    }

    public static ValidatableResponse generateLauncher(String token, LauncherBody body) {
        return given()
                .spec(set())
                .contentType(ContentType.JSON)
                .body(body)
                .header("Authorization","Bearer " + token)
                .when()
                .put("launchers/binary")
                .then();
    }

    public static ValidatableResponse createGrunts(String token) {
        return given()
                .spec(set())
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer " + token)
                .when()
                .get("grunts")
                .then();
    }

    public static ValidatableResponse deleteListener(Integer listenerId, String token) {

        return given()
                .spec(set())
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer " + token)
                .when()
                .delete("listeners/" + listenerId)
                .then();
    }
}
