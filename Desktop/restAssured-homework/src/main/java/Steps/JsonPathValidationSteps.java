package Steps;

import Data.StaticStrings;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class JsonPathValidationSteps {
    StaticStrings staticStrings = new StaticStrings();
    Response response;
    JsonPath jsonPath;

    @Step
    public JsonPathValidationSteps responseStep(){
        RestAssured.baseURI = staticStrings.baseURI;
        response = given()
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract()
                .response();
        return this;
    }

    @Step
    public JsonPathValidationSteps turnToJSon(){
        jsonPath = response.then().extract().jsonPath();;
        return this;
    }

    @Step
    public JsonPathValidationSteps pageAssertStep(){
        List<Integer> pages = jsonPath.getList("books.pages");
        assertThat(pages, everyItem(lessThan(1000)));
        return this;
    }

    @Step
    public JsonPathValidationSteps authorValidationStep(){
        List<String> authors =jsonPath.getList("books[0,1].author");
        assertThat(authors, contains(staticStrings.author1,staticStrings.author2));
        return this;
    }
}
