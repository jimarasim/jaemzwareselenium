package pages;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }
    public void waitForPageToLoad(int timeoutInSeconds) {
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    protected void switchToWindowHandleWithTitle(String title) throws InvalidArgumentException{
        for(String handle : driver.getWindowHandles()){
            driver.switchTo().window(handle);
            String windowTitle = driver.getTitle();
            if(windowTitle.equals(title) || windowTitle.equals("") ){
                System.out.println("TITLE:" + driver.getTitle() + "FOUND");
                return;
            } else{
                System.out.println("TITLE:" + driver.getTitle());
            }
        }
        throw new InvalidArgumentException("WINDOW WITH TITLE NOT FOUND:" + title);
    }

    protected void scrollToBottomOfPage(){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
}
