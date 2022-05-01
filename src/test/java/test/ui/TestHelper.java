package test.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.api.covenant.models.response.launcher.ResponseLauncher;
import test.api.covenant.models.response.listener.ResponseHttpListener;
import test.api.covenant.models.response.login.ResponseLogin;
import test.api.covenant.models.response.users.ResponseUsers;

import java.time.Duration;
import java.util.HashMap;
public abstract class TestHelper {
    protected WebDriver driver;
    protected String basePath;
    protected String loginEndpoint = "/covenantuser/login";
    protected String launcherEndpoint = "/launcher/create/5";
    protected ResponseLogin responseLogin;
    protected ResponseHttpListener responseHttpListener;
    protected ResponseLauncher responseLauncher;
    protected ResponseUsers responseUsers;

    protected String adminToken;



    public WebElement getElement (String xPath)
    {
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)));

        }
        catch (StaleElementReferenceException e)
        {
            return driver.findElement(By.xpath(xPath));
        }

    }

    protected WebDriver configureDriver (WebDriver driver)
    {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        String downloadDir = System.getProperty("user.dir") + "\\src\\test\\resources";
        chromePrefs.put("download.default_directory", downloadDir);
        chromePrefs.put("basePath", "http://host.docker.internal");
        chromePrefs.put("download.prompt_for_download", false);
        chromePrefs.put("safebrowsing.enabled", true);
        chromeOptions.setExperimentalOption("prefs", chromePrefs);
        chromeOptions.addArguments("ignore-certificate-errors");
        chromeOptions.addArguments("--safebrowsing-disable-download-protection");
        chromeOptions.addArguments("safebrowsing-disable-extension-blacklist");
        driver = new ChromeDriver(chromeOptions);

        return driver;
    }

}
