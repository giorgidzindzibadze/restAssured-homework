package Steps;
import Data.StaticStrings;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import org.json.simple.JSONObject;
import io.restassured.response.Response;

public class UpdateDataSteps {
    StaticStrings staticStrings = new StaticStrings();
    JSONObject putRequest = new JSONObject();
    JSONObject bookingdates = new JSONObject();

    private String token;
    public Response putResponse;




    @Step
    public void generateToken(){
        JSONObject getToken = new JSONObject();
        getToken.put("username", staticStrings.username);
        getToken.put("password", staticStrings.password);

        Response tokenResponse = RestAssured.given()
                .contentType("application/json")
                .body(getToken.toString())
                .post("https://restful-booker.herokuapp.com/auth");

        token = tokenResponse.jsonPath().getString("token");

    }


    @Step
    public UpdateDataSteps JSONobjStep(){
        putRequest.put("firstname", staticStrings.firstname);
        putRequest.put("lastname", staticStrings.lastname);
        putRequest.put("totalprice", staticStrings.totalprice);
        putRequest.put("depositpaid", true);
        putRequest.put("additionalneeds", staticStrings.additionalneeds);
        return this;
    }

    @Step
    public UpdateDataSteps bookingDatesStep(){
        bookingdates.put("checkin", staticStrings.checkin);
        bookingdates.put("checkout", staticStrings.checkout);
        putRequest.put("bookingdates", bookingdates);
        return this;
    }

    @Step
    public void putResponseStep(){
         putResponse = RestAssured.given()
                .contentType("application/json")
                .accept("application/json")
                .header("Cookie", "token=" + token)
                .body(putRequest.toString())
                .put("https://restful-booker.herokuapp.com/booking/1");
    }

    @Step
    public UpdateDataSteps validation(){
        putResponse.then().log().ifStatusCodeIsEqualTo(200).extract().statusCode();
        return this;
    }

}
