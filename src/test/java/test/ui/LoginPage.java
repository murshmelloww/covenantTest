package test.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    By usernameLocator = By.xpath("//*[@id=\"CovenantUserRegister_UserName\"]");
    By passwordLocator = By.xpath("//*[@id=\"CovenantUserRegister_Password\"]");
    By loginButtonLocator = By.xpath("/html/body/div/form/button");

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage typeUsername(String username) {
        driver.findElement(usernameLocator).sendKeys(username);
        return this;
    }

    public LoginPage typePassword(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
        return this;
    }

    public LoginPage submitLogin() {
        driver.findElement(loginButtonLocator).submit();
        return new LoginPage(driver);
    }

    public LoginPage submitLoginExpectingFailure() {
        driver.findElement(loginButtonLocator).submit();
        return new LoginPage(driver);
    }

    public LoginPage loginAs(String username, String password) {
        typeUsername(username);
        typePassword(password);
        return submitLogin();
    }

}
