package PageFactory.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

public class MainSwoopPage {
     WebDriver driver;



    public MainSwoopPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,20), this);
    }

    @FindAll(@FindBy(className = "MoreCategories"))
    public List<WebElement> kinoList;

    public MainSwoopPage clickOnKino() {
        WebElement kinoElement = kinoList.get(0); // Change the index as needed
        kinoElement.click();
        return this;

    }





}
