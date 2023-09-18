package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ThirdPage {
    public SelenideElement firstName =  $("#firstName"),
                           lastName = $("#lastName"),
                           gender =$("label[for='gender-radio-1']"),
                           mobileNumber = $("#userNumber"),
                           submitButton = $("#submit");




}
