package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SecondPage {
    public SelenideElement practiceButton =  $(By.xpath("//span[text()='Practice Form']"));
}
