package tests.AnalogArchive;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AnalogArchive.Home;
import tests.BaseTest;

public class playFirstSong extends BaseTest {

    @Test
    public void playFirstSongTest() {
        Home page = new Home(driver);
        page.load().clickFirstSong();
        Assert.assertEquals(1, page.getPlaylistSongCount());
    }

}
