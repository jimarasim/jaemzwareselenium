package pages.Jaemzware;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class Phonewords extends BasePage {
    private WebDriver driver;

    public Phonewords(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private By phoneNumberTextBox = By.id("phonenumber");
    private By areaDropdown = By.id("area");
    private By prefixDropdown = By.id("prefix");
    private By suffixDropdown = By.id("suffix");

    public Phonewords load() {
        driver.get("https://jaemzware.com/phonewords");
        return this;
    }

    public Phonewords sendKeysToPhonenumber(String phonenumber){
        driver.findElement(phoneNumberTextBox).sendKeys(phonenumber);
        return this;
    }

    public boolean isPhonenumberChoiceAvailable(){
        boolean isPhonenumberChoiceAvailable = false;
        isPhonenumberChoiceAvailable = driver.findElement(areaDropdown).isEnabled() &&
                driver.findElement(prefixDropdown).isEnabled() &&
                driver.findElement(suffixDropdown).isEnabled();
        return isPhonenumberChoiceAvailable;
    }
}
