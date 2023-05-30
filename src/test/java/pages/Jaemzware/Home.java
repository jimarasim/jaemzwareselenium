package pages.Jaemzware;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Home extends BasePage {
    private WebDriver driver;

    public Home(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private By jaemzwareHeader = By.xpath("//h1[text()[contains(.,'current projects')]]");
    private By phonewordsLink = By.id("phonewordslink");

    public Home load() {
        driver.get("https://jaemzware.com");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(jaemzwareHeader)));
        return this;
    }

    public boolean isJaemzwareHeaderPresent(){
        return driver.findElement(jaemzwareHeader).isDisplayed();
    }

    public Phonewords clickPhonewordsLink(){
        String currentWindowHandle = driver.getWindowHandle();
        driver.findElement(phonewordsLink).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        //Set<String> does not guarantee order of window handles
        Set<String> windowHandles = driver.getWindowHandles();
        List<String> windowHandlesList = new ArrayList<>(windowHandles);
        for(String handle : windowHandlesList){
            if(currentWindowHandle != handle){
                driver.switchTo().window(handle);
            }
        }
        Phonewords phonewords = new Phonewords(driver);
        phonewords.waitForPhoneNumberTextBox();
        return phonewords;
    }

}
