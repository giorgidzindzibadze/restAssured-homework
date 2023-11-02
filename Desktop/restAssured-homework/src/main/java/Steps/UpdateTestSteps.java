package Steps;

import Data.StaticStrings;
import Models.request.BookingDatesLombok;
import Models.request.BookingLombok;
import Models.response.BookLombok;
import io.qameta.allure.Step;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class UpdateTestSteps {
    StaticStrings staticStrings = new StaticStrings();
    BookingLombok root = new BookingLombok();

    RequestSpecification requestSpecification;
    int id;
    BookLombok bookLombok;
    Response response;
    Response response2;

    @Step("this step gets value from DataProvider")
    public UpdateTestSteps addStringss(String checkin, String checkout, String firstname, String lastname, int totalprice,
                                boolean booLean, String additionalneeds, int salesPice, String passportNo) {
        BookingDatesLombok bookingDatesLombok = new BookingDatesLombok();
        bookingDatesLombok.setCheckIn(checkin);
        bookingDatesLombok.setCheckOut(checkout);
        root.setFirstName(firstname);
        root.setLastName(lastname);
        root.setTotalPrice(totalprice);
        root.setDepositPaid(booLean);
        root.setAdditionalNeeds(additionalneeds);
        root.setBookingDates(bookingDatesLombok);
        root.setSalesprice(salesPice);
        root.setPassportNo(passportNo);
        return this;
    }

    @Step("this is requestSpecification test")
    public UpdateTestSteps specTest() {
         requestSpecification = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .auth()
                .preemptive()
                .basic(staticStrings.username, staticStrings.password)
                .filter(new AllureRestAssured());
        return this;
    }

    @Step("this step gets ID")
    public UpdateTestSteps getId() {
        Response bookingIdResponse = requestSpecification.get("https://restful-booker.herokuapp.com/booking/");
         id = bookingIdResponse
                .then()
                .extract()
                .jsonPath()
                .getInt("[0].bookingid");
         ;
        return this;
    }


    @Step("this step makes update")
    public UpdateTestSteps updateStep(){
         response =requestSpecification
                .body(root)
                .put(staticStrings.idURL + id);
        return this;
    }

    @Step("this step cast response in response class")
    public UpdateTestSteps cast(){
         response2 = RestAssured.given()
                .when()
                .get(staticStrings.idURL + id);
        bookLombok = response2.as(BookLombok.class);
        return this;
    }

    @Step("this step makes validations")
    public UpdateTestSteps validation(){
        assertThat(response2.getStatusCode(),equalTo(200));
        assertThat(root.getFirstName(), equalTo(bookLombok.getFirstName()));
        assertThat(root.getLastName(),equalTo(bookLombok.getLastName()));

        return this;
    }


}
