package tests.Scratch;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Scratch.Home;
import tests.BaseTest;

public class closePopup extends BaseTest {
    @Test
    public void closePopup(){
        Home page = new Home(driver);
        page.load();
    }
}
