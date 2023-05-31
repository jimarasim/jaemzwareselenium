package pages.Jaemzware;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

public class Skatecreteordie extends BasePage {

    public Skatecreteordie(WebDriver driver) {
        super(driver);
    }

    private By anImage = By.xpath("//img[contains(@src,'seattlerules')]");
    private By appleStoreLink = By.xpath("//h1/a[text()[contains(.,'skatecreteordie for iOS')]]");

    public boolean isAppleStoreLinkDisplayed(){
        return driver.findElement(appleStoreLink).isDisplayed();
    }

    public Skatecreteordie waitForRootDiv(){
        wait.until(ExpectedConditions.presenceOfElementLocated(anImage));
        return this;
    }
}
