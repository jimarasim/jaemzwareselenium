package tests.AnalogArchive;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AnalogArchive.Home;
import tests.BaseTest;

public class playVisibleSongs extends BaseTest {

    @Test
    public void playVisibleSongsTest() {
        Home page = new Home(driver);
        int songsChecked = page.load().clickVisibleSongs();
        Assert.assertEquals(songsChecked, page.getPlaylistSongCount());
    }

}
