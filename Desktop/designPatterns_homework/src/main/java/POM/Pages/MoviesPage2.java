package POM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MoviesPage2 extends BaseTest {
    List<WebElement> allmovies = driver.findElements(By.className("movies-deal"));

    public MoviesPage2 clickOnKino() {
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
        return this;
    }
}



