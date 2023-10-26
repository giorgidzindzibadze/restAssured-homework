import Steps.UpdateDataSteps;
import Steps.ValidationTestSteps;
import org.testng.annotations.Test;



public class restTest2 {
    UpdateDataSteps updateDataSteps = new UpdateDataSteps();
    ValidationTestSteps validationTestSteps = new ValidationTestSteps();

    @Test
    public void updataDatas(){
        updateDataSteps.generateToken();
        updateDataSteps.JSONobjStep()
                .bookingDatesStep()
                .putResponseStep();
        updateDataSteps.putResponseStep();
        updateDataSteps.validation();
    }

    @Test
    public void validationTest(){
        validationTestSteps.pagesValidation()
                .authorsValidation();
    }
}
