package tests.StuffedAnimalWar;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.StuffedAnimalWar.Analog;
import pages.StuffedAnimalWar.Home;
import pages.StuffedAnimalWar.Sk8;
import tests.BaseTest;

public class validPasswordForMusic extends BaseTest {

    @Test
    public void validPasswordForMusicTest(){
        Home page = new Home(driver);
        page.load().enterPassword("analog").clickGoButton().waitForPasswordTextBoxNotDisplayed();
        Analog analogPage = new Analog(driver);
        analogPage.waitForPageToLoad(30);
        Assert.assertTrue(analogPage.isAudioPlayerNextButtonDisplayed());
    }
}
