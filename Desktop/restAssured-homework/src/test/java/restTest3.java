import Steps.JsonPathValidationSteps;
import Steps.SpecTestSteps;
import org.testng.annotations.Test;


public class restTest3 {
    SpecTestSteps specTestSteps = new SpecTestSteps();
    JsonPathValidationSteps jsonPathValidationSteps = new JsonPathValidationSteps();

    @Test
    public void specTest(){
        specTestSteps.specStep()
                .getId()
                .deleteBooking()
                .validateStatusCode();

    }

    @Test
    public void jsonPathValidation(){
        jsonPathValidationSteps.responseStep()
                .turnToJSon()
                .pageAssertStep()
                .authorValidationStep();
    }

}

