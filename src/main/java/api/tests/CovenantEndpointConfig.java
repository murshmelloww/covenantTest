package api.tests;

import api.tests.models.request.LoginBody;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class CovenantEndpointConfig extends CovenantEndpointSpec {

    public static ValidatableResponse create (LoginBody body) {

        return given()
                .spec(set())
                .body(body)
                .when()
                .post()
                .then();

    }
}
