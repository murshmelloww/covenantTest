package test.api;

import test.api.covenant.models.response.launcher.ResponseLauncher;
import test.api.covenant.models.response.listener.ResponseHttpListener;
import test.api.covenant.models.response.login.ResponseLogin;
import test.api.covenant.models.response.users.ResponseUsers;


public class TestHelper {

    protected ResponseLogin responseLogin;
    protected ResponseHttpListener responseHttpListener;
    protected ResponseLauncher responseLauncher;
    protected ResponseUsers responseUsers;

    protected String adminToken;

}
