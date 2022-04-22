package api.tests;

import api.tests.models.request.LoginBody;
import api.tests.models.response.ResponseLogin;

public class CreateLoginPost {

    static ResponseLogin code200 (LoginBody body)
    {
        return CovenantEndpointConfig.create(body)
                .assertThat()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getObject("", ResponseLogin.class);
    }
}
