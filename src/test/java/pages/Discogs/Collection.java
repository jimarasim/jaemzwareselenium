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

    private String minimumPriceXpath = "//td[@data-header='Min']";
    private String mediumPriceXpath = "//td[@data-header='Med']";
    private String maximumPriceXpath = "//td[@data-header='Max']";
    private String artistAlbumXpath = "//div[@class='collection-card-title']";
    private String mediaFormatXpath = "//span[@class='collection-card-data']";
    private String releaseTableRowXpath = "//tr[contains(@class,'collection-row')]";
    private By next = By.xpath("/.//div[@class='responsive_wrap ']//a[@class='pagination_next']");
    private By loginLink = By.id("log_in_link");

    public Collection load(){
        driver.get("https://www.discogs.com/user/sk8creteordie/collection?page=1&layout=med");
        waitForPageToLoad(10);
        wait.until(ExpectedConditions.presenceOfElementLocated(next));
        return this;
    }

    public StringBuilder getCollectionPageRowsAsHtml(){
        List<WebElement> releaseTableRows = driver.findElements(By.xpath(releaseTableRowXpath));
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=1; i <= releaseTableRows.size(); i++){
            String minimumPriceString = "";
            String mediumPriceString = "";
            String maximumPriceString = "";
            String artistAlbumString = driver.findElement(By.xpath(releaseTableRowXpath + "["+i+"]" + artistAlbumXpath)).getText();
            String mediaFormatString = driver.findElement(By.xpath(releaseTableRowXpath + "["+i+"]" + mediaFormatXpath)).getText();
            if(driver.findElements(By.xpath(releaseTableRowXpath + "["+i+"]" + minimumPriceXpath)).size() > 0){
                minimumPriceString = driver.findElement(By.xpath(releaseTableRowXpath + "["+i+"]" + minimumPriceXpath)).getText();
            }
            if(driver.findElements(By.xpath(releaseTableRowXpath + "["+i+"]" + mediumPriceXpath)).size() > 0){
                mediumPriceString = driver.findElement(By.xpath(releaseTableRowXpath + "["+i+"]" + mediumPriceXpath)).getText();
            }
            if(driver.findElements(By.xpath(releaseTableRowXpath + "["+i+"]" + maximumPriceXpath)).size() > 0){
                maximumPriceString = driver.findElement(By.xpath(releaseTableRowXpath + "["+i+"]" + maximumPriceXpath)).getText();
            }
            stringBuilder.append("<tr>" +
                    "<td style=\"border: 1px solid black;\">"+artistAlbumString+"</td>" +
                    "<td style=\"border: 1px solid black;\">"+mediaFormatString+"</td>" +
                    "<td style=\"border: 1px solid black;\">"+minimumPriceString+"</td>" +
                    "<td style=\"border: 1px solid black;\">"+mediumPriceString+"</td>" +
                    "<td style=\"border: 1px solid black;\">"+maximumPriceString+"</td>" +
                    "</tr>");
//            stringBuilder.append("<tr><td style=\"border: 1px solid black;\">"+row.getText()+"</td></tr>");
            System.out.println("<tr>" +
                    "<td style=\"border: 1px solid black;\">"+artistAlbumString+"</td>" +
                    "<td style=\"border: 1px solid black;\">"+mediaFormatString+"</td>" +
                    "<td style=\"border: 1px solid black;\">"+minimumPriceString+"</td>" +
                    "<td style=\"border: 1px solid black;\">"+mediumPriceString+"</td>" +
                    "<td style=\"border: 1px solid black;\">"+maximumPriceString+"</td>" +
                    "</tr>");
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
