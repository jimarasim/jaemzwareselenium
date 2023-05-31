package pages.Jaemzware;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class Skatecreteordie extends BasePage {

    public Skatecreteordie(WebDriver driver) {
        super(driver);
    }

    private By appleStoreLink = By.xpath("//h1/a[text()[contains(.,'skatecreteordie for iOS')]]");

    public boolean isAppleStoreLinkDisplayed(){
        return driver.findElement(appleStoreLink).isDisplayed();
    }
}
