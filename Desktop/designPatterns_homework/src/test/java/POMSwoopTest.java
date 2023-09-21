import POM.Pages.FirstMoviePage2;
import POM.Pages.MainSwoopPage2;
import POM.Pages.MoviesPage2;
import POM.Pages.PopUpPage2;
import PageFactory.Pages.FirstMoviePage;
import PageFactory.Pages.MainSwoopPage;
import PageFactory.Pages.MoviesPage;
import PageFactory.Pages.PopUpPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class POMSwoopTest {
    WebDriver driver;


    @Test
    public void POMSwoopTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.swoop.ge/");
        driver.manage().window().maximize();



        MainSwoopPage2 mainSwoopPage2 = new MainSwoopPage2();
        mainSwoopPage2.clickOnKino();

        MoviesPage2 moviesPage2 = new MoviesPage2();
        moviesPage2.clickOnKino();

        FirstMoviePage2 firstMoviePage2 = new FirstMoviePage2();
        firstMoviePage2.clickOnEastPoint();
        firstMoviePage2.clickOnLastDate();
        firstMoviePage2.checkText();
        firstMoviePage2.clickOnLastMovie();
        PopUpPage2 popUpPage2 = new PopUpPage2();
        popUpPage2.clickOnVacantPlace();
        popUpPage2.checkMovieTime();
        popUpPage2.checkMovieName();
        popUpPage2.checkCinema();




    }
}
