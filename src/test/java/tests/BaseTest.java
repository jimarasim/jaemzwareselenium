package tests;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BaseTest {
    protected WebDriver driver = null;
    @BeforeMethod
    public void setup(){
        String browser = System.getProperty("browser"); //passed through maven with -Dbrowser
        if (browser==null || browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "./binaries/chromedriver");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");  // Enable headless mode
            driver = new ChromeDriver(options);
        } else if (browser.equals("safari")){
            driver = new SafariDriver();
        } else if (browser.equals("firefox")){
            System.setProperty("webdriver.gecko.driver", "./binaries/geckodriver");
            driver = new FirefoxDriver();
        } else{
            throw new IllegalArgumentException("INVALID BROWSER SPECIFIED: " + browser + ". PLEASE USE: safari OR chrome");
        }
    }

    @AfterMethod
    public void tearDown(ITestResult result){
        if (result.getStatus() == ITestResult.FAILURE) {
            captureFailureScreenshot(result.getName());
        } else{
            captureSuccessScreenshot(result.getName());
        }
        driver.quit();
    }

    private void captureFailureScreenshot(String testName){
        // Cast the WebDriver instance to TakesScreenshot
        TakesScreenshot screenshot = (TakesScreenshot) driver;

        // Capture the screenshot as a file
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);

        // Define the destination file path
        String destinationPath = "./screenshots/" + testName + "FAILED.png";

        try {
            // Copy the screenshot file to the destination path
            Files.copy(srcFile.toPath(), new File(destinationPath).toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Screenshot saved: " + destinationPath);
            System.out.println(driver.getPageSource());
        } catch (IOException e) {
            e.printStackTrace();
        }

        String successPath = "./screenshots/" + testName + "SUCCESS.png";
        if(new File(successPath).exists()){
            screenshotComparison(testName, successPath, destinationPath);
        }
    }

    private void captureSuccessScreenshot(String testName){
        // Cast the WebDriver instance to TakesScreenshot
        TakesScreenshot screenshot = (TakesScreenshot) driver;

        // Capture the screenshot as a file
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);

        // Define the destination file path
        String destinationPath = "./screenshots/" + testName + "SUCCESS.png";

        if(new File(destinationPath).exists()){
            destinationPath = destinationPath.replace("SUCCESS", "LATEST");
        }

        try {
            // Copy the screenshot file to the destination path
            Files.copy(srcFile.toPath(), new File(destinationPath).toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Screenshot saved: " + destinationPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(destinationPath.contains("LATEST")){
            screenshotComparison(testName, destinationPath.replace("LATEST", "SUCCESS"), destinationPath);
        }
    }

    private void screenshotComparison(String testName, String screenshot1Path, String screenshot2Path) {

        try {
            BufferedImage screenshot1 = ImageIO.read(new File(screenshot1Path));
            BufferedImage screenshot2 = ImageIO.read(new File(screenshot2Path));

            int width = screenshot1.getWidth();
            int height = screenshot1.getHeight();

            BufferedImage diffImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

            int diffPixels = 0;

            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int pixel1 = screenshot1.getRGB(x, y);
                    int pixel2 = screenshot2.getRGB(x, y);

                    if (pixel1 != pixel2) {
                        // Set pixel color to highlight the difference
                        diffImage.setRGB(x, y, 0xFF0000); // Red color
                        diffPixels++;
                    } else {
                        // Set pixel color to be the same as original
                        diffImage.setRGB(x, y, pixel1);
                    }
                }
            }

            // Save the difference image
            String diffImagePath = "./screenshots/" + testName + "COMPARISON.png";;
            ImageIO.write(diffImage, "png", new File(diffImagePath));

            System.out.println("SCREENSHOT COMPARISON DIFF PIXELS: " + diffPixels);

        } catch (Exception e) {
            System.out.println("SCREENSHOT EXCEPTION:"+ e.getMessage());
            e.printStackTrace();
        }
    }


}
