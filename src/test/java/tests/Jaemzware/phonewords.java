package tests.Jaemzware;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Jaemzware.Home;
import pages.Jaemzware.Phonewords;
import tests.BaseTest;

public class phonewords extends BaseTest {

    @Test
    public void phonewordsTest(){
        Home page = new Home(driver);
        Phonewords phonewordsPage = page.load().clickPhonewordsLink().sendKeysToPhonenumber("2063727265");
        Assert.assertTrue(phonewordsPage.isPhonenumberChoiceAvailable());
    }

}
