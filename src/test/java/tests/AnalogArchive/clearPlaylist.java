package tests.AnalogArchive;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AnalogArchive.Home;
import tests.BaseTest;

public class clearPlaylist extends BaseTest {

    @Test
    public void clearPlaylist() {
        Home page = new Home(driver);
        page.load().clickFirstSong().clickClearButton();
        Assert.assertEquals(0, page.getPlaylistSongCount());
    }
}
