//import POM.Steps.MainSwoopPageSteps;
import PageFactory.Pages.FirstMoviePage;
import PageFactory.Pages.MainSwoopPage;
import PageFactory.Pages.MoviesPage;

import io.qameta.allure.*;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Epic("User Journey: Movie Booking on Swoop.ge")
@Listeners(Config.class)
public class PageFactory extends BaseTests {
//    WebDriver driver;

    @Feature("Movie Booking")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description: this is test which have few steps, with the help of these steps, test open swoop page" +
            "click on kino button, than click of first movie which has cavea east point cinema, than scrolles down," +
            "click cavea east point and than last date of dates, after all of this it clicks last movie")
    @Story("Test opens Swoop.ge, selects a movie, and completes the booking process.")
    @Test(description = "Swoop Page test")
    public void runMainSwoopPageSteps()  throws InterruptedException {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
        driver.get("https://www.swoop.ge/");
//        driver.manage().window().maximize();

        MainSwoopPage mainSwoopPage = new MainSwoopPage(driver);
        mainSwoopPage.clickOnKino();
        //Assert.fail("asa");  amis sashualebit  vaeroreb

        MoviesPage moviesPage = new MoviesPage(driver);
        moviesPage.clickOnKino();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        FirstMoviePage firstMoviePage = new FirstMoviePage(driver);
        String ki = firstMoviePage.eastPoint.getText();
        js.executeScript("window.scrollBy(0, 300);");
        firstMoviePage.clickOnEastPoint(ki);
        js.executeScript("window.scrollBy(0, 300);");
        firstMoviePage.clickOnLastDate();

//        firstMoviePage.checkText();


//        firstMoviePage.clickOnLastMovie();
//
////
//        PopUpPage popUpPage = new PopUpPage(driver);
//        popUpPage.clickOnVacantPlace();
//        Assert.fail("asa");
//        driver.quit();
//        popUpPage.checkMovieTime();
//        popUpPage.checkMovieName();
//        popUpPage.checkCinema();




    }


}