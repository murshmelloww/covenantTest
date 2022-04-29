package test.ui;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FrontTest extends TestHelper {

    @BeforeAll
    public void configbrowser()
    {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        String downloadDir = System.getProperty("user.dir") + "\\src\\test\\resources";
        chromePrefs.put("download.default_directory", downloadDir);
        chromePrefs.put("download.prompt_for_download", false);
        chromePrefs.put("safebrowsing.enabled", true);
        chromeOptions.setExperimentalOption("prefs", chromePrefs);
        chromeOptions.addArguments("ignore-certificate-errors");
        chromeOptions.addArguments("--safebrowsing-disable-download-protection");
        chromeOptions.addArguments("safebrowsing-disable-extension-blacklist");
        driver = new ChromeDriver(chromeOptions);
        basePath = "https://127.0.0.1:7443";
    }

    @Test
    public static void downLoadFileTest(String user, String password) throws InterruptedException {


        driver.get(basePath + loginEndpoint);
        getElement(userLogin).sendKeys(user);
        getElement(userPassword).sendKeys(password);
        getElement(loginButton).click();
        driver.get(basePath + launcherEndpoint);
        getElement(generateButton).click();
        getElement(downloadButton).click();
    }

    @AfterAll
    public void driverClose ()
    {
        driver.close();
    }
}
