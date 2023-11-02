import Data.Provider;
import Steps.UpdateTestSteps;
import org.testng.annotations.Test;

public class restTest5 {

    UpdateTestSteps updateTestSteps = new UpdateTestSteps();

    @Test(dataProvider = "data", dataProviderClass = Provider.class)
    public void main(String checkin,String checkout, String firstname, String lastname, int totalprice,
                   boolean booLean, String additionalneeds, int salesPice, String passportNo){

        updateTestSteps.addStringss(checkin,checkout,firstname,lastname,totalprice,booLean,additionalneeds,
                                salesPice,passportNo)
                .specTest()
                .getId()
                .updateStep()
                .cast()
                .validation();
    }

}
