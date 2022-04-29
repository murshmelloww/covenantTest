package utils.testhelpers;

import api.tests.models.response.launcher.ResponseLauncher;
import api.tests.models.response.listener.ResponseHttpListener;
import api.tests.models.response.login.ResponseLogin;
import api.tests.models.response.users.ResponseUsers;


public class TestHelper {

    protected ResponseLogin responseLogin;
    protected ResponseHttpListener responseHttpListener;
    protected ResponseLauncher responseLauncher;
    protected ResponseUsers responseUsers;

    protected String adminToken;

}
