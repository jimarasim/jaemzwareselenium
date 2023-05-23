package tests.AnalogArchive;

import org.testng.annotations.Test;
import pages.AnalogArchiveHome;
import tests.BaseTest;

public class clearPlaylist extends BaseTest {

    @Test
    public void clearPlaylist() {
        AnalogArchiveHome page = new AnalogArchiveHome(driver);
        page.load().clickFirstSong().clickClearButton();
    }
}
