package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {
    protected WebDriverWait tenSecondWait;
    public BasePage(WebDriver driver){
        tenSecondWait = new WebDriverWait(driver, 10);
    }
}
