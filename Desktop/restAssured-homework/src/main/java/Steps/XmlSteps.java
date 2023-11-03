package Steps;

import Data.StaticStrings;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

public class XmlSteps {
    StaticStrings staticStrings = new StaticStrings();
    Response response;
    XmlPath xmlPath;

    @Step
    public  XmlSteps getXml(){
        response = RestAssured.get(staticStrings.xmlUrl);
         xmlPath = response.xmlPath();
        return this;
    }

    @Step
    public XmlSteps countValidation(){
        int sNameCount = xmlPath.getList("ArrayOftContinent.tContinent.sName").size();
        assertThat(sNameCount, equalTo(staticStrings.expectedSize));

        return this;
    }

    @Step
    public XmlSteps valuesValidation(){
        List<String> actuaValues = xmlPath.getList("ArrayOftContinent.tContinent.sName");

        for (String act: actuaValues){
            assertThat(staticStrings.expectedSrings, hasItem(act));

        }
        return this;
    }

    @Step
    public XmlSteps aNValidation(){
        String sNameForSCodeANs = xmlPath.getString("ArrayOftContinent.tContinent.find { it.sCode == 'AN' }.sName");
        assertThat(sNameForSCodeANs, equalTo(staticStrings.antarctica));
        return this;
    }

    @Step
    public XmlSteps lastContinentValidation(){
        String expected = staticStrings.expectedSrings.get(staticStrings.expectedSrings.size() -1);
        String actual = xmlPath.getString("ArrayOftContinent.tContinent[-1].sName");
        assertThat(expected, equalTo(actual));
        return this;
    }
}
