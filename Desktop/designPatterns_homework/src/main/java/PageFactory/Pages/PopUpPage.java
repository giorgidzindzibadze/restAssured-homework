package PageFactory.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

public class PopUpPage {
    WebDriver driver;
    JavascriptExecutor js = (JavascriptExecutor) driver;

    public PopUpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
    }

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

    @FindAll(@FindBy(className = "seat-new-part"))
    public List<WebElement> vacantPlace;

    @FindAll(@FindBy(css = "/div.seanse-details"))
    public List<WebElement> movieTime;



    String actualMovieName = movieNameElement.getText();
    String actualCinema = cinemaElement.getText();
    String actualDatetime = datetimeElement.getText();
    String expectedMovieName =movieName.getText();
    String expectedCinema = "კავეა სითი მოლი საბურთალო";



    public PopUpPage clickOnVacantPlace(){
        vacantPlace.get(0).click();
        return this;
    }
    public PopUpPage checkMovieTime(){
        for (WebElement each : movieTime
        ) {
            String eachText = each.getText().trim();
            if (eachText.contains(actualDatetime)) {
            }
        }
        return this;
    }

    public PopUpPage checkMovieName(){
        assert actualMovieName.equals(expectedMovieName);
        return this;

    }

    public PopUpPage checkCinema(){
        assert actualCinema.equals(expectedCinema);
        return this;
    }
}

