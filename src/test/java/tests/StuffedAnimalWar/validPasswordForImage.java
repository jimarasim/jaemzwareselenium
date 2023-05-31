package tests.StuffedAnimalWar;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.StuffedAnimalWar.Analog;
import pages.StuffedAnimalWar.Home;
import pages.StuffedAnimalWar.Sk8;
import tests.BaseTest;

public class validPasswordForImage extends BaseTest {
    @Test
    public void validPasswordForImageTest(){
        Home page = new Home(driver);
        page.load().enterPassword("sk8").clickGoButton().waitForPasswordTextBoxNotDisplayed();
        Sk8 sk8Page = new Sk8(driver);
        sk8Page.waitForPageToLoad(30);
        Assert.assertTrue(sk8Page.isLightGirlDisplayed());
    }
}
