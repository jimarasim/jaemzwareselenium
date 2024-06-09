package tests.SkateParks;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.io.PrintWriter;
import java.util.*;

public class SkateParks extends BaseTest {

    @Test
    public void TnaBoard() throws Exception{
        String destination = "https://www.tnaboard.com/community/forums/wa-provider-posts.98/";
        String linksXpath = "//div[@class='structItem-title']/a[last()]";
        driver.get(destination);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(linksXpath)));
        List<WebElement> webElements = driver.findElements(By.xpath(linksXpath));
        List<String> urls = new ArrayList<>();
        for(WebElement we : webElements) {
            urls.add(we.getAttribute("href"));
        }
        List<String[]> results = new ArrayList<>();
        int debugbreak = 0;
        for(String url : urls) {
            driver.quit();
            driver = new ChromeDriver(options);
            driver.get(url);
            String name = getTextIfElementExists("//h1");
//            String location = getTextIfElementExists("//div[@class='portfolio-details-location']/h5");
//            String geocodeurl = getAttributeIfElementExists("//iframe[contains(@src,'google.com/maps')]", "src");
//            String address = getTextIfElementExists("//p[contains(text(),'ADDRESS:')]");
//            String subtext = getTextIfElementExists("//div[@id='content']");
//            String size = getTextIfElementExists("//div[@class='portfolio-details-size']/h5");
            List<String> images = getAttributesIfElementsExist("//article[contains(@class,'message-body')]//img[not(contains(@class,'emoji'))] | //a[contains(@class,'file-preview')]/img","src");
            String image = String.join(" ", images);
//            results.add(new String[] { name, location, geocodeurl, address, size, url, image});
//            results.add(new String[] { name, location, url, size, address, geocodeurl, subtext});
            results.add(new String[] { name, url, image});
//            if(++debugbreak > 1)
//                break;
        }
        WriteContentsToWebPage(results, "tnaboard");
    }

    @Test
    public void SpohnRanch() throws Exception{
        String destination = "https://www.spohnranch.com/skatepark-design-build-portfolio/";
        String linksXpath = "//h3/a";
        driver.get(destination);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(linksXpath)));
        List<WebElement> webElements = driver.findElements(By.xpath(linksXpath));
        List<String> urls = new ArrayList<>();
        for(WebElement we : webElements) {
            urls.add(we.getAttribute("href"));
        }
        List<String[]> results = new ArrayList<>();
        int debugbreak = 0;
        for(String url : urls) {
            driver.navigate().to(url);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='portfolio-details-title']/h5")));
            String name = getTextIfElementExists("//div[@class='portfolio-details-title']/h5");
//            String location = getTextIfElementExists("//div[@class='portfolio-details-location']/h5");
//            String geocodeurl = getAttributeIfElementExists("//iframe[contains(@src,'google.com/maps')]", "src");
//            String address = getTextIfElementExists("//p[contains(text(),'ADDRESS:')]");
//            String subtext = getTextIfElementExists("//div[@id='content']");
//            String size = getTextIfElementExists("//div[@class='portfolio-details-size']/h5");
            List<String> images = getAttributesIfElementsExist("//ul[@class='slides']/li/img","src");
            String image = String.join(" ", images);
//            results.add(new String[] { name, location, geocodeurl, address, size, url, image});
//            results.add(new String[] { name, location, url, size, address, geocodeurl, subtext});
            results.add(new String[] { name, url, image});

//            if(++debugbreak > 5)
//                break;
        }
        WriteContentsToWebPage(results, "spohnranch");
    }

    @Test
    public void Newline() throws Exception{
        String destination = "https://www.newlineskateparks.com/projects/?all=1";
        String linksXpath = "//div[@id='myposts']//a";
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
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='intro-text']//h3")));
//            String city = getTextIfElementExists("//div[@class='intro-text']//h3");
            String name = getTextIfElementExists("//div[@class='intro-text']//h2");
            String googlemap = getAttributeIfElementExists("//iframe[contains(@src,'https://www.google.com/maps')]", "src");
//            List<String> images = getAttributesIfElementsExist("//div[contains(@class,'masonry-item')]//img","src");
//            String image = String.join(" ", images);
//            results.add(new String[] { name, googlemap, city, url, image});
            results.add(new String[] { name, googlemap});
        }
        WriteContentsToWebPage(results, "newline");
    }
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

    @Test
    public void Fsr() throws Exception{
        driver.get("https://fsrbeton.dk/projekter/");
        List<WebElement> webelementparks = driver.findElements(By.xpath("//a[@class='wpgb-card-layer-link']"));
        List<String> parks = new ArrayList<String>();
        for(WebElement we: webelementparks) {
            String url = we.getAttribute("href");
            parks.add(url);
        }
        List<String[]> results = new ArrayList<>();
        By nameBy = By.xpath("//h1[contains(@id,'headline')]");
        By addressBy = By.xpath("//div[contains(@class,'skatepark-adress')]/span");
        By sizeBy = By.xpath("//div[contains(text(),'Størrelse')]/../div[3]/span");
        By slideBy = By.xpath("//div[contains(@class,'swiper-slide')]//img");
        int incrementer=0;
        for(String park : parks) {
            String name="no name";
            String address="no address";
            String size="no size";
            List<String> images= new ArrayList<String>();
            driver.get(park);
            if(isElementPresent(nameBy)) {
                WebElement we = driver.findElement(nameBy);
                name = we.getText();
            }
            if(isElementPresent(addressBy)) {
                WebElement we = driver.findElement(addressBy);
                address = we.getText();
            }
            if(isElementPresent(sizeBy)) {
                WebElement we = driver.findElement(sizeBy);
                size = we.getText();
            }
            if(isElementPresent(slideBy)) {
                List<WebElement> wes = driver.findElements(slideBy);
                for(WebElement we : wes) {
                    String url = we.getAttribute("src");
                    images.add(url);
                }
            }
            // put each image in an array with its name address size and park/url
            String[] imageArray = images.toArray(new String[0]);
            String[] newArray = new String[imageArray.length + 4];
            System.arraycopy(imageArray, 0, newArray, 0, imageArray.length);
            newArray[newArray.length - 1] = newArray[0];
            newArray[newArray.length - 2] = newArray[1];
            newArray[newArray.length - 3] = newArray[2];
            newArray[newArray.length - 4] = newArray[3];
            newArray[0] = name;
            newArray[1] = address;
            newArray[2] = size;
            newArray[3] = park;
            results.add(newArray);
            if(++incrementer>1);
        }
        WriteContentsToWebPage(results, "fsr");
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
                    //MULTPILE IMAGES SUPPORTED WHEN PASSED AS A STRING OF IMAGE URLS SEPARATED BY SPACES AND ENDING WITH AN IMAGE EXTENSION (SEE NEWLINE AND getAttributesIfElementsExist)
                    if(cell.trim().toLowerCase().contains("jpg") || cell.trim().toLowerCase().contains("jpeg") || cell.trim().toLowerCase().contains("png") || cell.trim().toLowerCase().contains("webp")) {
                        List<String> images = Arrays.asList(cell.split("\\s+"));
                        images.forEach(image -> writer.println("<td><a target='_blank' href='"+image+"'><img width='300' height='200' src='" + image + "'></a>|</td>"));
                    } else if (cell.trim().toLowerCase().startsWith("http://") || cell.trim().toLowerCase().startsWith("https://")) {
                        writer.println("<td><a target='_blank' href='"+cell+"'>" + cell + "</a>|</td>");
                    }
                    else
                        writer.println("<td>" + cell + "|</td>");
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

        String jQueryInclude = "<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js'></script>";

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
        returnString.append(".info {background-color:#C0C0C0;color:#000000;}").append("</style>");
        returnString.append("<script src=\"https://code.jquery.com/jquery-3.6.0.min.js\"></script>");
        returnString.append("</head>");
        returnString.append("<body><b>");
        returnString.append(titleHeaderString);
        returnString.append("</b>");

        return (returnString.toString());

    }

    protected static String HtmlReportFooter() {
        return("</body></html>");
    }
}
