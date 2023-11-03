import Steps.SoapUISteps;
import Steps.XmlSteps;
import org.testng.annotations.Test;



public class restTest6 {
    XmlSteps xmlSteps = new XmlSteps();
    SoapUISteps soapUISteps = new SoapUISteps();

    @Test
    public void XmlTest(){
        xmlSteps.getXml()
                .countValidation()
                .valuesValidation()
                .aNValidation()
                .lastContinentValidation();
    }


    @Test
    public void SoapUITest(){
        soapUISteps.sendRequest()
                .getXmlPath()
                .validations();
    }

}
