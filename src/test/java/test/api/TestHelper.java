package test.api;

import test.api.models.response.launcher.ResponseLauncher;
import test.api.models.response.listener.ResponseHttpListener;
import test.api.models.response.login.ResponseLogin;
import test.api.models.response.users.ResponseUsers;


public class TestHelper {

    protected ResponseLogin responseLogin;
    protected ResponseHttpListener responseHttpListener;
    protected ResponseLauncher responseLauncher;
    protected ResponseUsers responseUsers;

    protected String adminToken;

}
