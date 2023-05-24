package tests.StuffedAnimalWar;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.StuffedAnimalWar.Home;
import tests.BaseTest;

public class noPassword extends BaseTest {
    @Test
    public void noPassword(){
        Home page = new Home(driver);
        page.load().clickGoButtonNoPassword();
        Assert.assertTrue(page.isPasswordTextBoxEnabled());
    }
}
