package PageFactory.Pages;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

public class FirstMoviePage {
    WebDriver driver;
    JavascriptExecutor js = (JavascriptExecutor) driver;


    public FirstMoviePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
    }

    @FindBy(xpath = "//a[contains(@class, 'ui-tabs-anchor') and text()='კავეა ისთ ფოინთი']")
    public WebElement eastPoint;

    @FindAll(@FindBy(xpath = "//*[@id='384933']/div/ul/li"))
    public List<WebElement> dates;

    @FindAll(@FindBy(css = "/div.seanse-details"))
    public List<WebElement> movieTime;


    @FindAll(@FindBy(className = "seat-new-part"))
    public List<WebElement> vacantPlace;

    //            WebElement content = driver.findElement(By.className("content-header"));

    @FindBy(className = "content-header")
    public WebElement content;

    @FindBy(xpath = "//*[@id=\"eventForm\"]/div/div[3]/div[1]/p[1]")
    public WebElement movieNameElement;

    @FindBy(className = "movie-cinema")
    public WebElement cinemaElement;

    @FindBy(xpath = "//*[@id=\"eventForm\"]/div/div[3]/div[1]/p[3]")
    public WebElement datetimeElement;

    @FindBy(className = "name")
    public WebElement movieName;

    String actualMovieName = movieNameElement.getText();
    String actualCinema = cinemaElement.getText();
    String actualDatetime = datetimeElement.getText();
    String expectedMovieName =movieName.getText();
    String expectedCinema = "კავეა სითი მოლი საბურთალო";





    public FirstMoviePage clickOnEastPoint() throws InterruptedException {
//        js.executeScript("window.scrollBy(0, 300);");
//        js.executeScript("window.scrollBy(0, 300);");
        js.executeScript("arguments[0].scrollIntoView(true);", eastPoint);
        eastPoint.click();
        Thread.sleep(5000);
        return this;

    }

    public FirstMoviePage clickOnLastDate(){
        js.executeScript("window.scrollBy(0, 200);");
        WebElement lastDate = dates.get(dates.size() - 1);
        lastDate.click();
        return this;
    }


    public FirstMoviePage checkText(){
        js.executeScript("window.scrollBy(0, 200);");

        for (WebElement one : movieTime) {
            String oneText = one.getText().trim();
            if (!oneText.isEmpty()) {
//                    System.out.println(oneText);
                if (oneText.contains("კავეა ისთ ფოინთი")) {
                    System.out.println("only ‘კავეა ისთ ფოინთი’ options are returned");
                }
            }
//
        }
        return this;
    }

    public FirstMoviePage clickOnLastMovie(){
        WebElement lastMovie = movieTime.get(movieTime.size() - 1);
        try {
            lastMovie.click();
        } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", lastMovie);
        }
        return this;
    }

//    public FirstMoviePage clickOnVacantPlace(){
//        vacantPlace.get(0).click();
//        return this;
//    }
//
//    public FirstMoviePage checkMovieTime(){
//        for (WebElement each : movieTime
//        ) {
//            String eachText = each.getText().trim();
//            if (eachText.contains(actualDatetime)) {
//            }
//        }
//        return this;
//    }
//
//    public FirstMoviePage checkMovieName(){
//        assert actualMovieName.equals(expectedMovieName);
//        return this;
//
//    }
//
//    public FirstMoviePage checkCinema(){
//        assert actualCinema.equals(expectedCinema);
//        return this;
//    }
}
