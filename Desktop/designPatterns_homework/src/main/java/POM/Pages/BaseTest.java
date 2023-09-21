package POM.Pages;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BaseTest {


    static WebDriver driver;
    JavascriptExecutor js = (JavascriptExecutor) driver;

    public void initialize(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.swoop.ge/");
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;

    }
    public static WebDriver getDriver() {
        return driver;
    }
}
