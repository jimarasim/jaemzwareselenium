package tests.StuffedAnimalWar;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.StuffedAnimalWar.Analog;
import pages.StuffedAnimalWar.Home;
import pages.StuffedAnimalWar.Sk8;
import tests.BaseTest;

public class validPassword extends BaseTest {
    @Test
    public void validPasswordForSk8Test(){
        Home page = new Home(driver);
        page.load().enterPassword("sk8").clickGoButton().waitForPasswordTextBoxNotDisplayed();
        Sk8 sk8Page = new Sk8(driver);
        sk8Page.waitForPageToLoad(driver,30);
        Assert.assertTrue(sk8Page.isLightGirlDisplayed());
    }
    @Test
    public void validPasswordForAnalogTest(){
        Home page = new Home(driver);
        page.load().enterPassword("analog").clickGoButton().waitForPasswordTextBoxNotDisplayed();
        Analog analogPage = new Analog(driver);
        analogPage.waitForPageToLoad(driver,30);
        Assert.assertTrue(analogPage.isAudioPlayerNextButtonDisplayed());
    }
}
