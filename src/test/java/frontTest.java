import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class frontTest {

    @Test
    public void fronttest () throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("ignore-certificate-errors");
        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get("https://127.0.0.1:7443/covenantuser/login");
        //System.out.println(driver.getPageSource());
        driver.findElement(By.xpath("//*[@id=\"CovenantUserRegister_UserName\"]")).sendKeys("admin");
        driver.findElement(By.xpath("//*[@id=\"CovenantUserRegister_Password\"]")).sendKeys("123");
        driver.findElement(By.xpath("/html/body/div/form/button")).click();
        driver.get("https://127.0.0.1:7443/launcher/create/5");
        //System.out.println(driver.getPageSource());
        try{
            driver.findElement(By.id("host-tab")).click();
        }
        catch (StaleElementReferenceException e)
        {
            driver.findElement(By.id("host-tab")).click();
        }

        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement path = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"Path\"]")));
            path.clear();
        }
        catch (StaleElementReferenceException e)
        {
            driver.findElement(By.xpath("//*[@id=\"Path\"]")).clear();
        }
        catch (ElementNotInteractableException e) {
            driver.findElement(By.xpath("//*[@id=\"Path\"]")).clear();
        }
        driver.findElement(By.xpath("//*[@id=\"Path\"]")).sendKeys("/GruntHTTP.exe");
        try
        {
            driver.findElement(By.xpath("//*[@id=\"covenant-container\"]/div/main")).click();
        }
        catch (ElementNotInteractableException e)
        {
            driver.findElement(By.xpath("//*[@id=\"covenant-container\"]/div/main")).click();
        }

        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement host_button = wait.until(ExpectedConditions.elementToBeClickable(By.id("host")));
            host_button.click();
        }
        catch (StaleElementReferenceException e)
        {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement host_button = wait.until(ExpectedConditions.elementToBeClickable(By.id("host")));
            host_button.click();
        }
        finally {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement host_button = wait.until(ExpectedConditions.elementToBeClickable(By.id("host")));
            host_button.click();
        }
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()",driver.findElement(By.xpath("//*[@id=\"host\"]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()",driver.findElement(By.xpath("//*[@id=\"host\"]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()",driver.findElement(By.xpath("//*[@id=\"host\"]")));
    }
}
