package pages.StuffedAnimalWar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

public class Sk8 extends BasePage {
    private WebDriver driver;
    public Sk8(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    private By lightGirlImage = By.xpath("//img[@src='https://stuffedanimalwar.com/images/lightgirl.jpeg']");

    public boolean isLightGirlDisplayed(){
        return driver.findElement(lightGirlImage).isDisplayed();
    }
}
