package tests.Discogs;

import org.testng.annotations.Test;
import pages.Discogs.Collection;
import tests.BaseTest;

import java.util.Arrays;

public class PrintCollection extends BaseTest {
    @Test
    public void printCollectionTest(){
        Collection collection = new Collection(driver);
        String headString = "<html><head><title>sk8creteordie collection</title></head><body><table style=\"border-collapse: collapse;\">";
        String footString = "</table></body></html>";
        StringBuilder contentStringBuilder = new StringBuilder();
        //GET COLLECTION ENTRIES
        collection.load().
                clickloginLink().
                sendKeysToUserName("sk8creteordie").
                sendKeysToPassword("D1ssC0gGZ5").
                clickLoginButton();
        do {
            contentStringBuilder.append(collection.getCollectionPageRows());
        }while(collection.clickNext());
        //SORT COLLECTION ENTRIES
        String[] collectionEntries = contentStringBuilder.toString().split("</tr>");
        Arrays.sort(collectionEntries);
        //REBUILD STRING BUILDER WITH HEADER, SORTED ENTRIES, AND FOOTER
        contentStringBuilder.setLength(0);
        contentStringBuilder.append(headString);
        for(String collectionEntry : collectionEntries){
            contentStringBuilder.append(collectionEntry).append("</tr>");
        }
        contentStringBuilder.append(footString);
        printHtmlReport(contentStringBuilder.toString());
    }
}
