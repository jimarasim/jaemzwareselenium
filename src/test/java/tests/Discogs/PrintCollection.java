package tests.Discogs;

import org.testng.annotations.Test;
import pages.Discogs.Collection;
import tests.BaseTest;

import java.util.Arrays;





public class PrintCollection extends BaseTest {
    @Test
    public void printCollectionTest(){
        Collection collection = new Collection(driver);
        String headString = "<html><head><title>sk8creteordie collection</title><script src=\"https://code.jquery.com/jquery-3.6.0.min.js\"></script><script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery.tablesorter/2.31.3/js/jquery.tablesorter.min.js\"></script></head><body>";
        headString += "<script>$(document).ready(function() {$(\"#myTable\").tablesorter();});</script>";
        headString += "<table id=\"myTable\" style=\"border-collapse: collapse;\">";
        headString += "<thead><tr><th>artist - title</th><th>format</th><th>min</th><th>med</th><th>max</th></tr></thead><tbody>";
        String footString = "</tbody></table></body></html>";
        StringBuilder contentStringBuilder = new StringBuilder();
        //GET COLLECTION ENTRIES
        collection.load().
                clickloginLink().
                sendKeysToUserName("sk8creteordie").
                sendKeysToPassword("D1ssC0gGZ5").
                clickLoginButton();
        do {
            contentStringBuilder.append(collection.getCollectionPageRowsAsHtml());
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
