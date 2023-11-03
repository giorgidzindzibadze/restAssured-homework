package Steps;

import Data.StaticStrings;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;

public class SoapUISteps {
    StaticStrings staticStrings = new StaticStrings();
    Response response;
    XmlPath xpathResult;

    @Step
    public SoapUISteps sendRequest(){
        File requestFilse = new File(getClass().getClassLoader().getResource("findPersonRequest.xml").getFile());

        response =
                RestAssured
                        .given()
                        .baseUri("https://www.crcind.com/csp/samples/SOAP.Demo.CLS?WSDL=1")
                        .header("SOAPAction", "http://tempuri.org/SOAP.Demo.FindPerson")
                        .header("Content-Type", "text/xml; charset=utf-8")
                        .contentType(ContentType.XML)
                        .body(requestFilse)
                        .post();
        return this;
    }

    @Step
    public SoapUISteps getXmlPath(){
         xpathResult = response.xmlPath();
        return this;
    }

    @Step
    public SoapUISteps validations(){
        int zip = xpathResult.getInt("Envelope.Body.FindPersonResponse.FindPersonResult.Office.Zip");
        String street = xpathResult.getString("Envelope.Body.FindPersonResponse.FindPersonResult.Home.Street");
        assertThat(zip,equalTo(staticStrings.zip));
        assertThat(street,equalTo(staticStrings.street));
        return this;
    }
}
