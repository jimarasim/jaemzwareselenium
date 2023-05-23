package tests.AnalogArchive;

import org.testng.annotations.Test;
import pages.AnalogArchiveHome;
import tests.BaseTest;

public class playFirstSong extends BaseTest {

    @Test
    public void playFirstSong() {
        AnalogArchiveHome page = new AnalogArchiveHome(driver);
        page.load().clickFirstSong();
    }

}
