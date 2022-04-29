import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class frontTest {

    @Test
    public void fronttest () throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://127.0.0.1:7443/launcher/create/5");
        driver.wait(10000);
    }
}
