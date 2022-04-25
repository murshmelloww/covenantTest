package api.tests;

import api.tests.models.request.listener.HttpListenerBody;
import api.tests.models.request.login.LoginBody;
import api.tests.models.response.listener.ResponseHttpListener;
import api.tests.models.response.login.ResponseLogin;
import io.restassured.response.Response;

public class CreatePost {

    static ResponseLogin code200 (LoginBody body)
    {
        return CovenantEndpointConfig.createLogin(body)
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .extract()
                .jsonPath()
                .getObject("", ResponseLogin.class);
    }
    static Response code200r (LoginBody body)
    {
        return CovenantEndpointConfig.createLogin(body)
                .assertThat()
                .statusCode(200)
                .extract().response();
    }

    static ResponseHttpListener code200 (HttpListenerBody body, String token)
    {
        return CovenantEndpointConfig.createListener(body, token)
                .assertThat()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getObject("", ResponseHttpListener.class);
    }
}
