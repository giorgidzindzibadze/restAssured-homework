import Data.LoginData;
import Steps.FirstPageSteps;
import Steps.FourthPageSteps;
import Steps.SecondPageSteps;
import Steps.ThirdPageSteps;
import com.codeborne.selenide.*;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.AssertionMode.SOFT;
import static com.codeborne.selenide.Configuration.*;

public class DataPatterns {
    @BeforeSuite
    public  void Suite(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        Configuration.browserCapabilities = options;
        Configuration.browserSize = null;
        timeout = 10000; // default is 4000, change N1
        holdBrowserOpen = false;
    }
    @BeforeTest
    public void SelenideTests() {
        screenshots = true; //change2
        reopenBrowserOnFail = true;
        downloadsFolder = "src/main/resources/Pictures";
        fastSetValue = true;
        assertionMode = SOFT;
        fileDownload = FileDownloadMode.HTTPGET;
        downloadsFolder = "src/main/resources/images";}

    FirstPageSteps firstPageStep = new FirstPageSteps();
    SecondPageSteps secondPageStep = new SecondPageSteps();
    ThirdPageSteps thirdPageStep =new ThirdPageSteps();
    FourthPageSteps fourthPageSteps = new FourthPageSteps();

    LoginData loginData = new LoginData();


    @Test(description = "Login Scenario")
    @Description("Success login scenario")
    @Story("Valid username and password login test")
    public void successLogin(){
        firstPageStep.clickAction();
        secondPageStep.clickAction2();
        thirdPageStep.FillFields(loginData.firstName,loginData.lastName);
        fourthPageSteps.checkText();
        fourthPageSteps.checkInfos();
    }

}
