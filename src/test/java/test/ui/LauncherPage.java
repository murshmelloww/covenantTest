package test.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LauncherPage {

    private final WebDriver driver;

    By pathTextBox = By.xpath("//*[@id=\"Path\"]");
    By hostTab = By.xpath("//*[@id=\"host-tab\"]");
    By hostButton = By.xpath("/html/body/app/div[2]/div/main/div[2]/div[2]/form/div[2]/div/div/div[2]/button");
    By generateButton = By.xpath("//*[@id=\"generate\"]");
    By downloadButton = By.xpath("//*[@id=\"download\"]");

    public LauncherPage (WebDriver driver) {
        this.driver = driver;
    }

    public LauncherPage typePath(String path) {
        getElement(pathTextBox).sendKeys(path);
        return this;
    }

    public LauncherPage cleanPath() {
        getElement(pathTextBox).clear();
        return this;
    }
    public LauncherPage openHostTab () {
        getElement(hostTab).click();
        return this;
    }

    public LauncherPage generateButtonClick () {
        getElement(generateButton).click();
        return this;
    }

    public LauncherPage hostButtonClick () {
        getElement(hostButton).click();
        return this;
    }

    public LauncherPage downloadButtonClick () {
        getElement(downloadButton).click();
        return this;
    }

    public LauncherPage downloadLauncher () {
        generateButtonClick();
        downloadButtonClick();
        return this;
    }

    public LauncherPage hostFile (String filePath)
    {
        openHostTab();
        cleanPath();
        typePath(filePath);
        hostButtonClick();
        return this;
    }

    private WebElement getElement (By xpath)
    {
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            return wait.until(ExpectedConditions.elementToBeClickable(xpath));

        }
        catch (StaleElementReferenceException e)
        {
            return driver.findElement(xpath);
        }

    }

}
