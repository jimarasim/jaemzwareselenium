package pages.Discogs;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.AnalogArchive.Home;
import pages.BasePage;

import java.util.List;

public class Collection extends BasePage {

    public Collection (WebDriver driver){
        super(driver);
    }

    private String releaseTableRowXpath = "//tr[contains(@class,'collection-row')]";
    private By next = By.xpath("/.//div[@class='responsive_wrap ']//a[@class='pagination_next']");
    private By loginLink = By.id("log_in_link");

    public Collection load(){
        driver.get("https://www.discogs.com/user/sk8creteordie/collection?page=1&layout=med");
        waitForPageToLoad(10);
        wait.until(ExpectedConditions.presenceOfElementLocated(next));
        return this;
    }

    public StringBuilder getCollectionPageRows(){
        List<WebElement> releaseTableRows = driver.findElements(By.xpath(releaseTableRowXpath));
        StringBuilder stringBuilder = new StringBuilder();
        for(WebElement row : releaseTableRows){
            stringBuilder.append("<tr><td style=\"border: 1px solid black;\">"+row.getText()+"</td></tr>");
        }
        return stringBuilder;
    }

    public boolean clickNext(){
        if(driver.findElements(next).size() > 0){
            scrollToBottomOfPage();
            driver.findElement(next).click();
            waitForPageToLoad(30);
            return true;
        }
        return false;
    }

    public Login clickloginLink(){
        driver.findElement(loginLink).click();
        Login loginPage = new Login(driver);
        loginPage.waitForUserName();
        return loginPage;
    }
}
