package tests.StuffedAnimalWar;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.StuffedAnimalWar.Home;
import tests.BaseTest;

public class noPassword extends BaseTest {
    @Test
    public void noPasswordTest(){
        Home page = new Home(driver);
        page.load().clickGoButton();
        Assert.assertTrue(page.isPasswordTextBoxEnabled());
    }
}
