//import POM.Steps.MainSwoopPageSteps;
import PageFactory.Pages.FirstMoviePage;
import PageFactory.Pages.MainSwoopPage;
import PageFactory.Pages.MoviesPage;
import PageFactory.Pages.PopUpPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PageFactory {
    WebDriver driver;
//    JavascriptExecutor js = (JavascriptExecutor) driver;
    @Test
    public void runMainSwoopPageSteps() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.swoop.ge/");
        driver.manage().window().maximize();

        MainSwoopPage mainSwoopPage = new MainSwoopPage(driver);
        mainSwoopPage.clickOnKino();

        MoviesPage moviesPage = new MoviesPage(driver);
        moviesPage.clickOnKino();

        FirstMoviePage firstMoviePage = new FirstMoviePage(driver);
//        js.executeScript("window.scrollBy(0, 300);");
        firstMoviePage.clickOnEastPoint();
        firstMoviePage.clickOnLastDate();
        firstMoviePage.checkText();
        firstMoviePage.clickOnLastMovie();
        PopUpPage popUpPage = new PopUpPage(driver);
        popUpPage.clickOnVacantPlace();
        popUpPage.checkMovieTime();
        popUpPage.checkMovieName();
        popUpPage.checkCinema();




    }
}

