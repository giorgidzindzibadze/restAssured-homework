package Steps;

import Data.StaticStrings;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;

public class ValidationTestSteps {
    StaticStrings staticStrings = new StaticStrings();
    public Response response;

    @Step
    public ValidationTestSteps pagesValidation(){
        RestAssured.baseURI = staticStrings.baseURI;

        response = RestAssured.get();
        response.then()
                .body("books.pages", everyItem(lessThan(1000)));
        return this;
    }

    @Step
    public ValidationTestSteps authorsValidation(){
        response.then()
                .body("books[0,1].author", contains(staticStrings.author1,staticStrings.author2));
        return this;

    }



}
