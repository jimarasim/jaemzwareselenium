package tests;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    public WebDriver driver = null;
    public BaseTest(){
        System.setProperty("webdriver.chrome.driver", "chromedriver");
    }

    public WebDriver getChromeDriver(){
        driver = new ChromeDriver();
        return driver;
    }

    public void releaseDriver(WebDriver driver){
        driver.quit();
    }
}
