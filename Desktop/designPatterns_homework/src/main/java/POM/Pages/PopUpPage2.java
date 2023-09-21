package POM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PopUpPage2 extends BaseTest {
    List<WebElement> vacantPlace = driver.findElements(By.className("seat-new-part"));
    List<WebElement> movieTime = driver.findElements(By.cssSelector("div.seanse-details"));

    WebElement movieNameElement = driver.findElement(By.xpath("//*[@id=\"eventForm\"]/div/div[3]/div[1]/p[1]"));
    WebElement cinemaElement = driver.findElement(By.className("movie-cinema"));
    WebElement datetimeElement = driver.findElement(By.xpath("//*[@id=\"eventForm\"]/div/div[3]/div[1]/p[3]"));

    String actualMovieName = movieNameElement.getText();
    String actualCinema = cinemaElement.getText();
    String actualDatetime = datetimeElement.getText();


    String expectedMovieName = driver.findElement(By.className("name")).getText();
    String expectedCinema = "კავეა სითი მოლი საბურთალო"; // არვიცი რატომ, მაგრამ როდესაც მომაქვს ისთ ფოინთი აღიქვამს როგორც კავეა სითი მოლი საბურთალო.

    public PopUpPage2 clickOnVacantPlace(){
        vacantPlace.get(0).click();
        return this;
    }
    public PopUpPage2 checkMovieTime(){
        for (WebElement each : movieTime
        ) {
            String eachText = each.getText().trim();
            if (eachText.contains(actualDatetime)) {
            }
        }

        return this;
    }

    public PopUpPage2 checkMovieName(){
        assert actualMovieName.equals(expectedMovieName);
        return this;

    }

    public PopUpPage2 checkCinema(){
        assert actualCinema.equals(expectedCinema);
        return this;
    }


}
