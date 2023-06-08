package pages.StuffedAnimalWar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

public class Sk8 extends BasePage {
    public Sk8(WebDriver driver) {
        super(driver);
    }
    private By lightGirlImage = By.xpath("//img[@src='https://stuffedanimalwar.com/images/lightgirl.jpeg']");

    public void waitForPageToLoad(int timeoutInSeconds) {
        super.waitForPageToLoad(timeoutInSeconds);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img")));
    }

    public boolean isLightGirlDisplayed(){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(lightGirlImage)));
        return driver.findElement(lightGirlImage).isDisplayed();
    }
}
