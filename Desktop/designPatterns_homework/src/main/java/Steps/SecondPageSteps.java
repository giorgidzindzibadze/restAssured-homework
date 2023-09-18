package Steps;

import Pages.SecondPage;
import io.qameta.allure.Step;


public class SecondPageSteps {
    SecondPage secondPage = new SecondPage();
    @Step
    public SecondPageSteps clickAction2(){
        secondPage.practiceButton.click();
        return this;
        }
}
