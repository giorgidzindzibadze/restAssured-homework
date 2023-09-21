package POM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FirstMoviePage2 extends BaseTest{

    WebElement eastpoint = driver.findElement(By.xpath("//a[contains(@class, 'ui-tabs-anchor') and text()='კავეა ისთ ფოინთი']"));

    List<WebElement> dates = driver.findElements(By.xpath("//*[@id='384933']/div/ul/li"));
    List<WebElement> movieTime = driver.findElements(By.cssSelector("div.seanse-details"));

        public FirstMoviePage2 clickOnEastPoint(){
            js.executeScript("window.scrollBy(0, 300);");
            eastpoint.click();
            return this;
        }

        public FirstMoviePage2 clickOnLastDate(){
            WebElement lastDate = dates.get(dates.size() - 1);
            lastDate.click();
            return this;
        }
        public FirstMoviePage2 checkText(){
            for (WebElement one : movieTime) {
//            try {
                String oneText = one.getText().trim();
                if (!oneText.isEmpty()) {
//                    System.out.println(oneText);
                    if (oneText.contains("კავეა ისთ ფოინთი")) {
                        System.out.println("only ‘კავეა ისთ ფოინთი’ options are returned");
                    }
                }
//
            }
            return this;
        }

        public FirstMoviePage2 clickOnLastMovie(){
            WebElement lastMovie = movieTime.get(movieTime.size() - 1);
            try {
                lastMovie.click();
            } catch (Exception e) {
                JavascriptExecutor executor = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", lastMovie);
            }
            return this;

        }


}
