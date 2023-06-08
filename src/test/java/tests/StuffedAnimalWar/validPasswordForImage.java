package tests.StuffedAnimalWar;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.StuffedAnimalWar.Home;
import pages.StuffedAnimalWar.Image;
import pages.StuffedAnimalWar.Sk8;
import tests.BaseTest;

public class validPasswordForImage extends BaseTest {
    @Test
    public void validPasswordForImageTest(){
        Home page = new Home(driver);
        page.load().enterPassword("beastieboysintergalactic").clickGoButton().waitForPasswordTextBoxNotDisplayed();
        Image imagePage = new Image(driver);
        imagePage.waitForPageToLoad(30);
        Assert.assertTrue(imagePage.isImageDisplayed("beastIMG_E8487.JPG"));
    }
}
