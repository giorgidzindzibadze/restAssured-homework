import Steps.RequestSteps;
import org.testng.annotations.Test;

public class restTest4 {
    RequestSteps requestSteps = new RequestSteps();

    @Test
    public void mainTest() {
        requestSteps.addStrings()
                .postRequest()
                .getId()
                .getRequest()
                .getInClass()
                .validation();
    }
}
