package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.AnalogArchiveHome;

public class AnalogArchive extends BaseTest{

    @Test
    public void playFirstSong() {
        WebDriver driver = getChromeDriver();
        AnalogArchiveHome page = new AnalogArchiveHome(driver);
        page.load().clickFirstSong();
        releaseDriver(driver);
    }

    @Test
    public void clearPlaylist() {
        WebDriver driver = getChromeDriver();
        AnalogArchiveHome page = new AnalogArchiveHome(driver);
        page.load().clickFirstSong().clickClearButton();
        releaseDriver(driver);
    }
}
