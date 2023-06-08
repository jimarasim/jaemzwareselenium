package tests.StuffedAnimalWar;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.StuffedAnimalWar.Home;
import pages.StuffedAnimalWar.Sk8;
import tests.BaseTest;

public class validPasswordForSk8 extends BaseTest {
    @Test
    public void validPasswordForSk8Test(){
        Home page = new Home(driver);
        page.load().enterPassword("sk8").clickGoButton().waitForPasswordTextBoxNotDisplayed();
        Sk8 sk8Page = new Sk8(driver);
        sk8Page.waitForPageToLoad(30);
        Assert.assertTrue(sk8Page.isLightGirlDisplayed());
    }
}
