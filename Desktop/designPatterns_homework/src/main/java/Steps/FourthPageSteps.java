package Steps;

import Data.LoginData;
import Pages.FourthPage;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

public class FourthPageSteps {
    FourthPage fourthPage = new FourthPage();
    LoginData loginData = new LoginData();

    @Step
    public FourthPageSteps checkText(){

        assert fourthPage.textField.isDisplayed();

        return this;

    }
    @Step
    public  FourthPageSteps checkInfos(){
        ElementsCollection tdElements= fourthPage.table.$$("td");
        SelenideElement firstName = tdElements.get(1);
        SelenideElement gender = tdElements.get(5);
        SelenideElement number = tdElements.get(7);
        String actualName = firstName.getText();
        String actualGender = gender.getText();
        String actualNumber = number.getText();


        String expectedName = loginData.firstName +" " + loginData.lastName;
        assert actualGender.equals(loginData.gender);
        assert actualName.equals(expectedName);
        assert actualNumber.equals(loginData.userNumber);

        return this;


    }

}
