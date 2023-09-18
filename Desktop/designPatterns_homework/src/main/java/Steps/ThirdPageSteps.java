package Steps;

import Data.LoginData;
import Pages.ThirdPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class ThirdPageSteps {
    ThirdPage thirdPage = new ThirdPage();
    LoginData loginData = new LoginData();

    @Step
    public ThirdPageSteps FillFields(){
        thirdPage.firstName.setValue(loginData.firstName);
        thirdPage.lastName.setValue(loginData.lastName);
        thirdPage.gender.click();
        thirdPage.mobileNumber.setValue(loginData.userNumber);
        executeJavaScript("window.scrollBy(0, 500);");
        executeJavaScript("document.querySelector('footer').remove();");
        executeJavaScript("document.querySelector('#fixedban').remove();");
        thirdPage.submitButton.click();
        return this;


    }
}
