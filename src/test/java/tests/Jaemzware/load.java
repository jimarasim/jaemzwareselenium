package tests.Jaemzware;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Jaemzware.Home;
import tests.BaseTest;

public class load extends BaseTest {

    @Test
    public void loadTest(){
        Home page = new Home(driver);
        page.load();
        Assert.assertTrue(page.isJaemzwareHeaderPresent());
    }

}
