package tests.Jaemzware;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Jaemzware.Home;
import pages.Jaemzware.Phonewords;
import pages.Jaemzware.Skatecreteordie;
import tests.BaseTest;

public class skatecreteordie extends BaseTest {

    @Test
    public void skatecreteordieTest(){
        Home page = new Home(driver);
        Skatecreteordie skatecreteordiePage = page.load().clickSkatecreteordieLink();
        Assert.assertTrue(skatecreteordiePage.isAppleStoreLinkDisplayed());
    }

}
