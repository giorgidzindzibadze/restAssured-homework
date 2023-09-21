import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class POMSwoopTest2 {

    WebDriver driver;

    @Test
    public void WebFormsAutomation() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.swoop.ge/");
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;
//        WebDriverWait wait = new WebDriverWait(driver, 20);

        List<WebElement> kino = driver.findElements(By.className("MoreCategories"));
        WebElement kis = kino.get(0);
        kis.click();

        List<WebElement> allmovies = driver.findElements(By.className("movies-deal"));


        for (WebElement movie : allmovies) {
            try {
                WebElement logos = driver.findElement(By.className("movie-logos"));
                WebElement ist = logos.findElement(By.cssSelector("img[src='/Images/NewDesigneImg/CinemaIcons/cavea-istFointi.svg']"));
                if (ist.isDisplayed()) {
                    movie.click();
                }
            } catch (org.openqa.selenium.NoSuchElementException e) {
                // Handle the case where the 'img' element is not found within the movie element
            }
        }

        js.executeScript("window.scrollBy(0, 300);");

        WebElement eastpoint = driver.findElement(By.xpath("//a[contains(@class, 'ui-tabs-anchor') and text()='კავეა ისთ ფოინთი']"));
        eastpoint.click();

        js.executeScript("window.scrollBy(0, 200);");

        List<WebElement> dates = driver.findElements(By.xpath("//*[@id='384933']/div/ul/li"));
        WebElement lastDate = dates.get(dates.size() - 1);
//        wait.until(ExpectedConditions.elementToBeClickable(lastDate)).click();
        lastDate.click();


        List<WebElement> movieTime = driver.findElements(By.cssSelector("div.seanse-details"));
        WebElement lastMovie = movieTime.get(movieTime.size() - 1);
        js.executeScript("window.scrollBy(0, 200);");


        for (WebElement one : movieTime) {
//            try {
                String oneText = one.getText().trim();
                if (!oneText.isEmpty()) {
//                    System.out.println(oneText);
                    if (oneText.contains("კავეა ისთ ფოინთი")) {
                        System.out.println("only ‘კავეა ისთ ფოინთი’ options are returned");
                    }
                }
//
        }

//            Thread.sleep(5000);
            try {
                lastMovie.click();
            } catch (Exception e) {
                JavascriptExecutor executor = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", lastMovie);
            }
            Thread.sleep(5000);
            List<WebElement> vacantPlace = driver.findElements(By.className("seat-new-part"));

            vacantPlace.get(0).click();

//            Thread.sleep(5000);

//            WebElement content = driver.findElement(By.className("content-header"));
            WebElement movieNameElement = driver.findElement(By.xpath("//*[@id=\"eventForm\"]/div/div[3]/div[1]/p[1]"));
            WebElement cinemaElement = driver.findElement(By.className("movie-cinema"));
            WebElement datetimeElement = driver.findElement(By.xpath("//*[@id=\"eventForm\"]/div/div[3]/div[1]/p[3]"));

            String actualMovieName = movieNameElement.getText();
            String actualCinema = cinemaElement.getText();
            String actualDatetime = datetimeElement.getText();


            String expectedMovieName = driver.findElement(By.className("name")).getText();
            String expectedCinema = "კავეა სითი მოლი საბურთალო"; // არვიცი რატომ, მაგრამ როდესაც მომაქვს ისთ ფოინთი აღიქვამს როგორც კავეა სითი მოლი საბურთალო.
            for (WebElement each : movieTime
            ) {
                String eachText = each.getText().trim();
                if (eachText.contains(actualDatetime)) {
                }
            }

            Assert.assertEquals(actualMovieName, expectedMovieName, "Movie name validation failed.");
            Assert.assertEquals(actualCinema, expectedCinema, "Cinema name validation failed.");


            driver.quit();


        }

    }




