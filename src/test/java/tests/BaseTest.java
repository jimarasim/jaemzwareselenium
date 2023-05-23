package tests;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver = null;
    public BaseTest(){
        System.setProperty("webdriver.chrome.driver", "chromedriver");
    }

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
