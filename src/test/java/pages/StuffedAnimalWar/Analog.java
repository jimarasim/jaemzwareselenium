package pages.StuffedAnimalWar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class Analog extends BasePage {
    private WebDriver driver;
    public Analog(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    private By analogPlayerNextPage = By.id("next");

    public boolean isAudioPlayerNextButtonDisplayed(){
        return driver.findElement(analogPlayerNextPage).isDisplayed();
    }
}
