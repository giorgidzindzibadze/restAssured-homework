package PageFactory.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

public class MoviesPage {
    WebDriver driver;


    public MoviesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
    }

    @FindAll(@FindBy(className = "movies-deal"))
    public List<WebElement> allmovies;

    @Step
    public MoviesPage clickOnKino() {
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