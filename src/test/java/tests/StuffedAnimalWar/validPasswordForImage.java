package tests.StuffedAnimalWar;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.StuffedAnimalWar.Home;
import pages.StuffedAnimalWar.Image;
import pages.StuffedAnimalWar.Sk8;
import tests.BaseTest;

public class validPasswordForImage extends BaseTest {
    @DataProvider(name = "imageData")
    public static Object[][] getImageData() {
        return new Object[][] {
                {"beastieboysintergalactic", "beastIMG_E8487.JPG"},
                {"beathappeningdreamy", "beatIMG_E8481.JPG"},
                {"deadcandancespiritchaser", "dcdIMG_E8477.JPG"},
                {"ianbrownmyway", "ianIMG_E8468.JPG"},
                {"misfitsearthad", "misfitsIMG_E8504.JPG"},
                {"fatboyslimyouvecomealongw", "IMG_8593.JPG"},
        };
    }
    @Test(dataProvider = "imageData")
    public void validPasswordForImageTest(String password, String anImageName){
        Home page = new Home(driver);
        page.load().enterPassword(password).clickGoButton().waitForPasswordTextBoxNotDisplayed();
        Image imagePage = new Image(driver);
        imagePage.waitForPageToLoad(30);
        System.out.println("PASSWORD:"+password);
        Assert.assertTrue(imagePage.isImageDisplayed(anImageName));
    }
}
