package pages.Scratch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

public class Home extends BasePage {
    private WebDriver driver;

    public Home(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public Home load() {
        By iCloseButton = By.xpath("//div[starts-with(@id,'wrap-close-button')]//span");
        driver.get("https://www.guardian.com.vn/");
        wait.until(ExpectedConditions.presenceOfElementLocated(iCloseButton));
        driver.findElement(iCloseButton).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(iCloseButton));
        return this;
    }

    public void waitForBatchJob() {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(waitForBatchJobComplete());
    }

    private ExpectedCondition<Boolean> waitForBatchJobComplete() {
        return driver -> {
            WebElement flag = driver.findElement(By.id("BATCH_JOB_STAT_FLG"));
            return flag.getText() == "Complete";
        };
    }
}
