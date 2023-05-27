package tests.StuffedAnimalWar;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.StuffedAnimalWar.Home;
import pages.StuffedAnimalWar.Sk8;
import tests.BaseTest;

public class validPassword extends BaseTest {
    @Test
    public void validPasswordTest(){
        Home page = new Home(driver);
        page.load().enterPassword("sk8").clickGoButton().waitForPasswordTextBoxNotDisplayed().waitForPageToLoad(driver,10);
        Sk8 sk8Page = new Sk8(driver);
        Assert.assertTrue(sk8Page.isLightGirlDisplayed());
    }
}
