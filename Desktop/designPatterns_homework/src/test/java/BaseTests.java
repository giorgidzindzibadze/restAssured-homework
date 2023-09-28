import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;

public class BaseTests {
    protected static WebDriver driver;

    @BeforeSuite
    public void initialize(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();

    }

    public static WebDriver getDriver() {
        return driver;
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }

}
