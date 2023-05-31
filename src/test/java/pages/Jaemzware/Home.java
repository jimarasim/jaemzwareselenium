package pages.Jaemzware;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

public class Home extends BasePage {

    public Home(WebDriver driver) {
        super(driver);
    }

    private By jaemzwareHeader = By.xpath("//h1[text()[contains(.,'current projects')]]");
    private By phonewordsLink = By.id("phonewordslink");
    private By skatecreteordieLink = By.xpath("//a[text()[contains(.,'skate')]]");

    public Home load() {
        driver.get("https://jaemzware.com");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(jaemzwareHeader)));
        return this;
    }

    public boolean isJaemzwareHeaderPresent(){
        return driver.findElement(jaemzwareHeader).isDisplayed();
    }

    public Phonewords clickPhonewordsLink(){
        driver.findElement(phonewordsLink).click();
        switchToWindowHandleWithTitle("Phone Words");
        Phonewords phonewords = new Phonewords(driver);
        phonewords.waitForPhoneNumberTextBox();
        return phonewords;
    }

    public Skatecreteordie clickSkatecreteordieLink(){
        driver.findElement(skatecreteordieLink).click();
        switchToWindowHandleWithTitle("skatecreteordie iOS App");
        Skatecreteordie skatecreteordie = new Skatecreteordie(driver);
        skatecreteordie.waitForRootDiv();
        return new Skatecreteordie(driver);
    }
}
