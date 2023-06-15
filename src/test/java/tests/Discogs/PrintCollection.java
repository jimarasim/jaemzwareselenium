package tests.Discogs;

import org.testng.annotations.Test;
import pages.Discogs.Collection;
import tests.BaseTest;

public class PrintCollection extends BaseTest {
    @Test
    public void printCollectionTest(){
        Collection collection = new Collection(driver);
        collection.load().
                clickloginLink().
                sendKeysToUserName("sk8creteordie").
                sendKeysToPassword("D1ssC0gGZ5").
                clickLoginButton();
        do {
            collection.printCollectionPage();
        }while(collection.clickNext());
    }


}
