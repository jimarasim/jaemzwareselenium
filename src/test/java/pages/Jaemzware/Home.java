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

    private By jaemzwareHeader = By.xpath("//h1[text()[contains(.,'jaemzware llc')]]");
    private By phonewordsLink = By.id("phonewordslink");

    public Home load() {
        driver.get("https://jaemzware.com");
        return this;
    }

    public boolean isJaemzwareHeaderPresent(){
        return driver.findElement(jaemzwareHeader).isDisplayed();
    }

    public Phonewords clickPhonewordsLink(){
        driver.findElement(phonewordsLink).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        Set<String> windowHandles = driver.getWindowHandles();
        List<String> list = new ArrayList<>(windowHandles);
        driver.switchTo().window(list.get(1));
        return new Phonewords(driver);
    }

}
