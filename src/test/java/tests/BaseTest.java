package tests;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class BaseTest {
    protected WebDriver driver = null;
    public BaseTest(){
        System.setProperty("webdriver.chrome.driver", "chromedriver");
    }

    @BeforeMethod
    public void setup(){
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");  // Enable headless mode
//        driver = new ChromeDriver(options);
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown(ITestResult result){
        if (result.getStatus() == ITestResult.FAILURE) {
            // Cast the WebDriver instance to TakesScreenshot
            TakesScreenshot screenshot = (TakesScreenshot) driver;

            // Capture the screenshot as a file
            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);

            // Define the destination file path
            String destinationPath = "./screenshots/" + result.getName() + ".png";

            try {
                // Copy the screenshot file to the destination path
                Files.copy(srcFile.toPath(), new File(destinationPath).toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Screenshot saved: " + destinationPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        driver.quit();
    }
}
