package tests.SkateParks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class SkateParks extends BaseTest {

    @Test
    public void TeamPain() throws Exception{
        String destination = "https://teampain.com/project-type/concrete/";
        String linksXpath = "//li[contains(@class,'video')]/a";
        driver.get(destination);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(linksXpath)));
        List<WebElement> webElements = driver.findElements(By.xpath(linksXpath));
        List<String> urls = new ArrayList<>();
        for(WebElement we : webElements) {
            urls.add(we.getAttribute("href"));
        }
        List<String[]> results = new ArrayList<>();
        for(String url : urls) {
            driver.navigate().to(url);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/section[2]/div/div/div/div/h1")));
            String name = getTextIfElementExists("/html/body/section[2]/div/div/div/div/h1");
            String address = getTextIfElementExists("//h2[contains(text(),'Location')]/following-sibling::p");
            String size = getTextIfElementExists("//h2[contains(text(),'Size')]/following-sibling::p");
            String image = getAttributeIfElementExists("//li[contains(@class,'wow')]/a[contains(@class,'bg-image')]/img","data-lazy-src");
            results.add(new String[] { name, address, size, url, image});
        }
        WriteContentsToWebPage(results, "teampain");
    }
    
    @Test
    public void Artisan() throws Exception{
        String destination = "https://www.artisanskateparks.com/";
        driver.get(destination);
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@class='folder-child']/li/a")));
        List<WebElement> parkLinks = driver.findElements(By.xpath("//ul[@class='folder-child']/li/a"));
        List<String[]> results = new ArrayList<>();
        for(WebElement link : parkLinks) {
            String name = link.getAttribute("title");
            String url = link.getAttribute("href");
            results.add(new String[] {name, url});
        }
        WriteContentsToWebPage(results, "artisan");
    }

    @Test
    public void Grindline() throws Exception{
        String parks[] = {
        "http://grindline.com/skateparks/4-directions-skatepark/",
        "http://grindline.com/skateparks/oceanside-alex-foussat/",
        "http://grindline.com/skateparks/athens/",
        "http://grindline.com/skateparks/aztec/",
        "http://grindline.com/skateparks/bakersfield-skatepark-expansion-bakersfield-ca/",
        "http://grindline.com/skateparks/mammoth-lakes/",
        "http://grindline.com/skateparks/buffalo/",
        "http://grindline.com/skateparks/carbondale/",
        "http://grindline.com/skateparks/aurora-city-park/",
        "http://grindline.com/skateparks/cody/",
        "http://grindline.com/skateparks/corpus-christi/",
        "http://grindline.com/skateparks/crooked-river-skate-park-cleveland-oh/",
        "http://grindline.com/skateparks/currituck-county/",
        "http://grindline.com/skateparks/de-vargas-park/",
        "http://grindline.com/skateparks/duck-pond/",
        "http://grindline.com/skateparks/edina/",
        "http://grindline.com/skateparks/edwards/",
        "http://grindline.com/skateparks/erie/",
        "http://grindline.com/skateparks/fairplay/",
        "http://grindline.com/skateparks/farmington-hills/",
        "http://grindline.com/skateparks/fayetteville/",
        "http://grindline.com/skateparks/freedom-park/",
        "http://grindline.com/skateparks/g-hysmith-skate-park-college-station-tx/",
        "http://grindline.com/skateparks/galveston/",
        "http://grindline.com/skateparks/grove-city/",
        "http://grindline.com/skateparks/winter-park/",
        "http://grindline.com/skateparks/hill-top/",
        "http://grindline.com/skateparks/athens-2/",
        "http://grindline.com/skateparks/imperial-beach-skatepark-san-diego-ca/",
        "http://grindline.com/skateparks/marietta/",
        "http://grindline.com/skateparks/jackson/",
        "http://grindline.com/skateparks/jonesboro/",
        "http://grindline.com/skateparks/kremmling/",
        "http://grindline.com/skateparks/lackland/",
        "http://grindline.com/skateparks/lakeway/",
        "http://grindline.com/skateparks/lee-and-jamil-skatepark/",
        "http://grindline.com/skateparks/amirillo-texas-martin-road-skatepark/",
        "http://grindline.com/skateparks/melba-bishop/",
        "http://grindline.com/skateparks/milford-skatepark-milford-ct/",
        "http://grindline.com/skateparks/mlk/",
        "http://grindline.com/skateparks/mt-view-skatepark/",
        "http://grindline.com/skateparks/nags-head-skate-park-nags-head-nc/",
        "http://grindline.com/skateparks/nani-falcone/",
        "http://grindline.com/skateparks/newburgh/",
        "http://grindline.com/skateparks/tyler/",
        "http://grindline.com/skateparks/atlantic-beach/",
        "http://grindline.com/skateparks/oxford/",
        "http://grindline.com/skateparks/pai-ani-mai-park/",
        "http://grindline.com/skateparks/kokomo/",
        "http://grindline.com/skateparks/pitcher-park-memorial-skatepark/",
        "http://grindline.com/skateparks/portage/",
        "http://grindline.com/skateparks/potrero-del-sol-skatepark-san-fransisco-ca-design-only/",
        "http://grindline.com/skateparks/prairie-village/",
        "http://grindline.com/skateparks/red-lake-high-school/",
        "http://grindline.com/skateparks/ridgway/",
        "http://grindline.com/skateparks/rockton/",
        "http://grindline.com/skateparks/san-antonio/",
        "http://grindline.com/skateparks/round-rock/",
        "http://grindline.com/skateparks/san-angelo/",
        "http://grindline.com/skateparks/san-marcos-phase-2/",
        "http://grindline.com/skateparks/scalzi-skatepark/",
        "http://grindline.com/skateparks/shawnee/",
        "http://grindline.com/skateparks/silver-city/",
        "http://grindline.com/skateparks/sitka/",
        "http://grindline.com/skateparks/athens-2/",
        "http://grindline.com/skateparks/south-jordan/",
        "http://grindline.com/skateparks/spring-park/",
        "http://grindline.com/skateparks/st-helena-park-st-helena-ca/",
        "http://grindline.com/skateparks/sturgeon-bay/",
        "http://grindline.com/skateparks/college-park/",
        "http://grindline.com/skateparks/telluride/",
        "http://grindline.com/skateparks/trinidad/",
        "http://grindline.com/skateparks/tuba-city/",
        "http://grindline.com/skateparks/west-maui/",
        "http://grindline.com/skateparks/west-point-skate-park-west-point-ms/"};
        List<String[]> results = new ArrayList<>();
        By sizeBy = By.xpath("//div[@class='stats']/div[contains(text(),\"Size\")]");
        By slideBy = By.xpath("//div[@id='parkSlideshow']/div[@class='slide']");
        for(String park : parks) {
            String size="n/a";
            List<String> images= new ArrayList<String>();
            driver.get(park);
            if(isElementPresent(sizeBy)) {
                WebElement we = driver.findElement(sizeBy);
                size = we.getText();
            }
            if(isElementPresent(slideBy)) {
                List<WebElement> wes = driver.findElements(slideBy);
                for(WebElement we : wes) {
                    String url = we.getAttribute("style");
                    int start = url.indexOf("https://");
                    int end = url.indexOf("\");");
                    if(start < end)
                        url = url.substring(start,end);
                    images.add(url);
                }
            }
            // put each image in an array and follow it up with size
            String[] imageArray = images.toArray(new String[0]);
            String[] newArray = new String[imageArray.length + 2];
            System.arraycopy(imageArray, 0, newArray, 0, imageArray.length);
            newArray[newArray.length - 1] = newArray[0];
            newArray[newArray.length - 2] = newArray[1];
            newArray[0] = park;
            newArray[1] = size;
            results.add(newArray);
        }
        WriteContentsToWebPage(results, "grindline");
    }

    @Test
    public void Evergreen() throws Exception{
        String parks[] = {
                "https://www.evergreenskateparks.com/alberton-montana-skatepark",
                "https://www.evergreenskateparks.com/belding",
                "https://www.evergreenskateparks.com/big-sandy-montana-skatepark-phase-2",
                "https://www.evergreenskateparks.com/box-elder-montana-skatepark",
                "https://www.evergreenskateparks.com/bozeman-montana-skatepark",
                "https://www.evergreenskateparks.com/buffalo-new-york-skate-plaza",
                "https://www.evergreenskateparks.com/camp-wood-kansas",
                "https://www.evergreenskateparks.com/carbondale-colorado-skatepark-phase-2",
                "https://www.evergreenskateparks.com/cashmere-washington-skatepark",
                "https://www.evergreenskateparks.com/clawson-michigan-skatepark",
                "https://www.evergreenskateparks.com/coeur-dalene-idaho-skatepark",
                "https://www.evergreenskateparks.com/crow-creek-skatepark-fort-thompson",
                "https://www.evergreenskateparks.com/darby-montana-skatepark",
                "https://www.evergreenskateparks.com/douglas-wyoming-skatepark",
                "https://www.evergreenskateparks.com/eau-claire-wisconsin-skatepark",
                "https://www.evergreenskateparks.com/epworth-skatepark-delaware",
                "https://www.evergreenskateparks.com/ferndale-michigan-skatepark",
                "https://www.evergreenskateparks.com/fort-morgan-colorado-skatepark",
                "https://www.evergreenskateparks.com/frankfort-michigan",
                "https://www.evergreenskateparks.com/fredericksburg-texas-skatepark",
                "https://www.evergreenskateparks.com/frisco-colorado-skatepark",
                "https://www.evergreenskateparks.com/goat-bowl-sonoma",
                "https://www.evergreenskateparks.com/hamilton-montana-skatepark",
                "https://www.evergreenskateparks.com/havre-montana-skatepark",
                "https://www.evergreenskateparks.com/hays-montana-skatepark",
                "https://www.evergreenskateparks.com/hernando-mississippi-skatepark",
                "https://www.evergreenskateparks.com/howard-heuston-boulder-colorado",
                "https://www.evergreenskateparks.com/idalou-texas-skatepark",
                "https://www.evergreenskateparks.com/johnson-city-skatepark",
                "https://www.evergreenskateparks.com/laytonville-california-skatepark",
                "https://www.evergreenskateparks.com/lewistown-montana-skatepark",
                "https://www.evergreenskateparks.com/lincoln-montana-skatepark",
                "https://www.evergreenskateparks.com/livingston-montana-skatepark",
                "https://www.evergreenskateparks.com/malta-montana-skatepark",
                "https://www.evergreenskateparks.com/milliken-colorado-skatepark",
                "https://www.evergreenskateparks.com/missouri-city-texas-skatepark",
                "https://www.evergreenskateparks.com/ride-it-sculpture-park-phase-3",
                "https://www.evergreenskateparks.com/scott-carpenter-boulder-colorado",
                "https://www.evergreenskateparks.com/sterling-heights",
                "https://www.evergreenskateparks.com/stevensville-montana-skatepark",
                "https://www.evergreenskateparks.com/sturtevant-wisconsin-skatepark",
                "https://www.evergreenskateparks.com/sunnyside-washington",
                "https://www.evergreenskateparks.com/superior-montana-skatepark",
                "https://www.evergreenskateparks.com/taylor-texas-skatepark",
                "https://www.evergreenskateparks.com/library-boulder-colorado",
                "https://www.evergreenskateparks.com/thunder-park-browning-montana",
                "https://www.evergreenskateparks.com/valmont-boulder-colorado",
                "https://www.evergreenskateparks.com/vernon-hills-illinois-skatepark",
                "https://www.evergreenskateparks.com/villa-park-illinois-skatepark",
                "https://www.evergreenskateparks.com/watertown-skatepark",
                "https://www.evergreenskateparks.com/weirdo-bowl",
                "https://www.evergreenskateparks.com/wolf-point-montana-skatepark",
                "https://www.evergreenskateparks.com/woodward-tahoe-skatepark"
        };
        List<String[]> results = new ArrayList<>();
        By nameBy = By.xpath("//h1");
        By slideBy = By.xpath("//div[contains(@class,'slide content-fit')]/img");
        for(String park : parks) {
            String name="n/a";
            List<String> images= new ArrayList<String>();
            driver.get(park);
            if(isElementPresent(nameBy)) {
                WebElement we = driver.findElement(nameBy);
                name = we.getText();
            }
            if(isElementPresent(slideBy)) {
                List<WebElement> wes = driver.findElements(slideBy);
                for(WebElement we : wes) {
                    String url = we.getAttribute("src");
                    images.add(url);
                }
            }
            // put each image in an array and follow it up with size
            String[] imageArray = images.toArray(new String[0]);
            String[] newArray = new String[imageArray.length + 2];
            System.arraycopy(imageArray, 0, newArray, 0, imageArray.length);
            newArray[newArray.length - 1] = newArray[0];
            newArray[newArray.length - 2] = newArray[1];
            newArray[0] = name;
            newArray[1] = park;
            results.add(newArray);
        }
        WriteContentsToWebPage(results, "evergreen");
    }
    
    public void WriteContentsToWebPage(List<String[]> results, String report) throws Exception
    {
        String fileName = "index" + report + ".htm";
        try (PrintWriter writer = new PrintWriter(fileName, "UTF-8")) {
            writer.println(HtmlReportHeader(report));
            writer.println("<table>");
            for (String[] entry : results) {
                writer.println("<tr>");
                for(String cell : entry) {
                    if(cell.toLowerCase().endsWith("jpg") || cell.toLowerCase().endsWith("jpeg") || cell.toLowerCase().endsWith("png"))
                        writer.println("<td><img width='300' height='200' src='" + cell + "'></td>");
                    else
                        writer.println("<td>" + cell + "</td>");
                }
                writer.println("</tr>");
            }
            writer.println("</table>");
            writer.println(HtmlReportFooter());
            writer.flush();
            System.out.println("open " + fileName);
        }
        catch(Exception ex){
            throw new Exception("COULD NOT USE PRINTWRITER TO STORE COLLECTED PAGE CONTENT");
        }
    }

    protected static String HtmlReportHeader(String titleHeaderString) {
        StringBuilder returnString = new StringBuilder();

        String jQueryInclude = "<script src=\"jquery-1.12.2.min\"></script>";

        // standard header
        returnString.append("<html><head>");
        returnString.append(jQueryInclude);
        returnString.append("<meta http-equiv=\"Content-Security-Policy\" content=\"default-src 'self'; img-src http://* https://* file://*;\">");
        returnString.append("<title>");
        returnString.append(titleHeaderString);
        returnString.append("</title>");
        returnString.append("<style>");
        returnString.append("table td, table th {border: 1px solid black;text-align:left;vertical-align:top;}");
        returnString.append(".warning {background-color:#C0C0C0;color:#FFFF00;}");
        returnString.append(".severe {background-color:#C0C0C0;color:#FF0000;}");
        returnString.append(".info {background-color:#C0C0C0;color:#000000;}").append("</style>").append("</head>");
        returnString.append("<body><b>");
        returnString.append(titleHeaderString);
        returnString.append("</b>");

        return (returnString.toString());

    }

    protected static String HtmlReportFooter() {
        return("</body></html>");
    }
}
