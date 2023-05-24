package pages.StuffedAnimalWar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

public class Home extends BasePage {
    private WebDriver driver;

    public Home(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private By passwordTextBox = By.id("password");
    private By goButton = By.id("submit");

    public Home load() {
        driver.get("https://stuffedanimalwar.com");
        tenSecondWait.until(ExpectedConditions.presenceOfElementLocated(passwordTextBox));
        tenSecondWait.until(ExpectedConditions.presenceOfElementLocated(goButton));
        return this;
    }

    public boolean isPasswordTextBoxEnabled() {
        return driver.findElement(passwordTextBox).isEnabled();
    }

    public Home clickGoButton() {
        driver.findElement(goButton).click();
        return this;
    }

    public Home enterPassword(String password) {
        driver.findElement(passwordTextBox).sendKeys(password);
        return this;
    }

    public void waitForPasswordTextBoxNotDisplayed(){
        tenSecondWait.until(ExpectedConditions.invisibilityOfElementLocated(passwordTextBox));
    }
}
