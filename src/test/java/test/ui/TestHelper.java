package test.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestHelper {
    protected WebDriver driver;
    protected String basePath;

    protected String path = "//*[@id=\"Path\"]";
    protected String userLogin = "//*[@id=\"CovenantUserRegister_UserName\"]";
    protected String userPassword="//*[@id=\"CovenantUserRegister_Password\"]";
    protected String loginButton = "/html/body/div/form/button";
    protected String hostTab = "//*[@id=\"host-tab\"]";
    protected String pathTextBox = "\"//*[@id=\\\"Path\\\"]\"";
    protected String hostButton = "/html/body/app/div[2]/div/main/div[2]/div[2]/form/div[2]/div/div/div[2]/button";
    protected String loginEndpoint = "/covenantuser/login";
    protected String launcherEndpoint = "/launcher/create/5";
    protected String generateButton = "//*[@id=\"generate\"]";
    protected String downloadButton = "//*[@id=\"download\"]";

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

}
