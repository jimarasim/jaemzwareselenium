package tests.AnalogArchive;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AnalogArchive.Home;
import tests.BaseTest;

public class playVisibleSongs extends BaseTest {

    @Test
    public void playVisibleSongs() {
        Home page = new Home(driver);
        int songsChecked = page.load().playVisibleSongs();
        Assert.assertEquals(songsChecked, page.getPlaylistSongCount());
    }

}
