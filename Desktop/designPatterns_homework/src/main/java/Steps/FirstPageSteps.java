package Steps;

import Pages.FirstPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;

public class FirstPageSteps {
    FirstPage firstPage = new FirstPage();

    @Step()
    public FirstPageSteps clickAction() {
        open("https://demoqa.com/");
        executeJavaScript("window.scrollBy(0, 200);");
        firstPage.formsButton.click();
        return this;
    }
}
