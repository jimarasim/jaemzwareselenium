package pages.StuffedAnimalWar;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

import java.util.function.Function;

public class Image extends BasePage {
    public Image(WebDriver driver) {
        super(driver);
    }

    public void waitForPageToLoad(int timeoutInSeconds) {
        super.waitForPageToLoad(timeoutInSeconds);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img")));
    }

    public boolean isImageDisplayed(String imageName){
        Function<String, By> byFunction = (imageXPath) -> By.xpath("//img[contains(@src, '" + imageXPath + "')]");
        By image = byFunction.apply(imageName);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(image)));
        return driver.findElement(image).isDisplayed();
    }
}
