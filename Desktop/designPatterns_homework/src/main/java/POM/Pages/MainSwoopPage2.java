package POM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainSwoopPage2 extends BaseTest{

    List<WebElement> kinolist = driver.findElements(By.className("MoreCategories"));

    public MainSwoopPage2 clickOnKino() {
    WebElement kinoElement = kinolist.get(0);
    kinoElement.click();
    return this;
}

}
