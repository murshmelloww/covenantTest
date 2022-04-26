package api.tests;

import api.tests.models.request.listener.HttpListenerBody;
import api.tests.models.request.login.LoginBody;
import api.tests.models.response.launcher.ResponseLauncher;
import api.tests.models.response.listener.ResponseHttpListener;
import api.tests.models.response.login.ResponseLogin;

public class CreateRequest {

    static ResponseLogin post200(LoginBody body)
    {
        return CovenantEndpointConfig.createLogin(body)
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .extract()
                .jsonPath()
                .getObject("", ResponseLogin.class);
    }

    static ResponseHttpListener post200(HttpListenerBody body, String token)
    {
        return CovenantEndpointConfig.createListener(body, token)
                .assertThat()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getObject("", ResponseHttpListener.class);
    }

    static ResponseLauncher post200 (String token)
    {
        return CovenantEndpointConfig.createLauncher(token)
                .assertThat()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getObject("", ResponseLauncher.class);
    }

    static ResponseLauncher get200 (String token)
    {
        return CovenantEndpointConfig.getLauncher(token)
                .assertThat()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getObject("", ResponseLauncher.class);
    }
}
