package utils.testhelpers;

import java.io.IOException;

public class TestHelper {

    protected void runHTTPserver ()
    {

    }

    protected void stopHTTPserver ()
    {

    }

    protected void downloadFileOnWindows() {
    }

    protected void runCovenantDocker() throws IOException {
        Process process = Runtime.getRuntime().exec("docker run -it -p 7443:7443 -p 80:80 -p 443:443 --name covenant -v /Users/apple/Covenant/Covenant/Data:/app/Data covenant --username AdminUser --computername 0.0.0.0");
    }

    protected void runWindowsDocker() throws IOException {

    }

    protected void stopCovenantDocker() throws IOException {
        Process process = Runtime.getRuntime().exec("docker stop covenant");
    }

    protected void stopWindowsDocker() throws IOException {

    }

    protected void executeFileOnWindows() {
    }

    protected void checkConnectionOnWindows() {
    }
}
