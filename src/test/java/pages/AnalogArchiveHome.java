package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AnalogArchiveHome extends BasePage {
    private WebDriver driver;
    public AnalogArchiveHome(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    private By clearButton = By.id("clear");
    private By firstSongInCheckList = By.xpath("//table[@id='songsTable']//input[@type='checkbox']");
    private By playList = By.id("analogplaylist");

    public AnalogArchiveHome load(){
        driver.get("https://analogarchive.com");
        WebElement songListDiv = tenSecondWait.until(ExpectedConditions.presenceOfElementLocated(firstSongInCheckList));
        return this;
    }

    public AnalogArchiveHome clickFirstSong(){
        driver.findElement(firstSongInCheckList).click();
        waitForSongs();
        return this;
    }

    public AnalogArchiveHome clickClearButton(){
        driver.findElement(clearButton).click();
        tenSecondWait.until(playListItemsEmpty());
        return this;
    }

    public void waitForSongs() {
        tenSecondWait.until(playListItemsGreaterThan(0));
    }

    private ExpectedCondition<Boolean> playListItemsGreaterThan(int count) {
        return driver -> {
            WebElement unorderedList = driver.findElement(playList);
            return unorderedList.findElements(By.tagName("li")).size() > count;
        };
    }

    private ExpectedCondition<Boolean> playListItemsEmpty() {
        return driver -> {
            WebElement unorderedList = driver.findElement(playList);
            return unorderedList.findElements(By.tagName("li")).size() == 0;
        };
    }
}
