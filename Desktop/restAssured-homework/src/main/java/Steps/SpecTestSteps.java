package Steps;

import Data.StaticStrings;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class SpecTestSteps {
    StaticStrings staticStrings = new StaticStrings();
    RequestSpecification requestSpecification;
    int id;
    Response response;
    @Step
    public SpecTestSteps specStep(){
         requestSpecification = RestAssured
                .given()
                 .contentType("ContentTypeJSON")
                 .accept("ContentTypeJSON")
                .auth()
                .preemptive()
                .basic(staticStrings.username, staticStrings.password);
         return this;
    }


    @Step
    public SpecTestSteps getId() {
        Response bookingIdResponse = requestSpecification.get(staticStrings.idURL);
         id = bookingIdResponse
                 .then()
                 .extract()
                 .jsonPath()
                 .getInt("[1].bookingid");
         return this;
    }
    @Step
    public SpecTestSteps deleteBooking() {
         response = requestSpecification.delete(staticStrings.idURL + id);
        System.out.println(response.asString());
         return this;
    }

    @Step
    public SpecTestSteps validateStatusCode(){
        assertThat(response.getStatusCode(),equalTo(201));
        return this;
    }

}
