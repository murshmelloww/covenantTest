package utils.testhelpers;

import api.tests.models.response.launcher.ResponseLauncher;
import api.tests.models.response.listener.ResponseHttpListener;
import api.tests.models.response.login.ResponseLogin;

import java.io.IOException;

public class TestHelper {

    protected ResponseLogin responseLogin;
    protected ResponseHttpListener responseHttpListener;
    protected ResponseLauncher downloadLauncher;
    protected ResponseLauncher responseLauncher;


    protected void runHTTPserver ()
    {

    }

    protected void stopHTTPserver ()
    {

    }

    protected void downloadFileOnWindows() {
    }

    protected void runCovenantDocker() throws IOException {
        //Process process = Runtime.getRuntime().exec("docker run -it -p 7443:7443 -p 80:80 -p 443:443 --name covenant -v /Users/apple/Covenant/Covenant/Data:/app/Data covenant --username AdminUser --computername 0.0.0.0");
    }

    protected void runWindowsDocker() throws IOException {

    }

    protected void stopCovenantDocker() throws IOException {
        //Process process = Runtime.getRuntime().exec("docker stop covenant");
    }

    protected void stopWindowsDocker() throws IOException {

    }

    protected void executeFileOnWindows() {
    }

    protected void checkConnectionOnWindows() {
    }
}
