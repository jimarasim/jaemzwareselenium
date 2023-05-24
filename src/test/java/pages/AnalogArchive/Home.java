package pages.AnalogArchive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

import java.util.List;

public class Home extends BasePage {
    private WebDriver driver;
    public Home(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    private By clearButton = By.id("clear");
    private By songInCheckList = By.xpath("//table[@id='songsTable']//input[@type='checkbox']");
    private By playList = By.id("analogplaylist");
    private By songInPlayList = By.xpath("//ul[@id='analogplaylist']/li");

    public Home load(){
        driver.get("https://analogarchive.com");
        WebElement songListDiv = tenSecondWait.until(ExpectedConditions.presenceOfElementLocated(songInCheckList));
        return this;
    }

    public Home clickFirstSong(){
        driver.findElement(songInCheckList).click();
        waitForSongs();
        return this;
    }

    public Home clickClearButton(){
        driver.findElement(clearButton).click();
        tenSecondWait.until(waitForPlayListItemsEmpty());
        return this;
    }

    public int clickVisibleSongs(){
        int songsChecked = 0;
        List<WebElement> songs = driver.findElements(songInCheckList);
        for(WebElement song : songs){
            if (song.isDisplayed()){
                song.click();
                songsChecked++;
            }
        }
        return songsChecked;
    }

    public int getPlaylistSongCount(){
        return driver.findElements(songInPlayList).size();
    }

    public void waitForSongs() {
        tenSecondWait.until(waitForPlayListItemsGreaterThan(0));
    }

    private ExpectedCondition<Boolean> waitForPlayListItemsGreaterThan(int count) {
        return driver -> {
            WebElement unorderedList = driver.findElement(playList);
            return unorderedList.findElements(By.tagName("li")).size() > count;
        };
    }

    private ExpectedCondition<Boolean> waitForPlayListItemsEmpty() {
        return driver -> {
            WebElement unorderedList = driver.findElement(playList);
            return unorderedList.findElements(By.tagName("li")).size() == 0;
        };
    }
}
