package tests.Scratch;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Scratch.Home;
import tests.BaseTest;

public class closePopup extends BaseTest {
//    @Test
    public void closePopupTest(){
        Home page = new Home(driver);
        page.load();
    }
}
