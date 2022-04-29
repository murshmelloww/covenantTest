package test.ui;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
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
        chromePrefs.put("download.default_directory", "src/test/resources");
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
    public void fronttest () throws InterruptedException {


        driver.get(basePath + loginEndpoint);
        getElement(userLogin).sendKeys("admin");
        getElement(userPassword).sendKeys("123");
        getElement(loginButton).click();
        driver.get(basePath + launcherEndpoint);
        getElement(generateButton).click();
        getElement(downloadButton).click();
    }

    @AfterAll
    public void driverClose ()
    {
        //driver.close();
    }
}
