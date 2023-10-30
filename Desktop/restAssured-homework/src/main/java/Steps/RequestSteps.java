package Steps;

import Data.StaticStrings;
import Models.request.Booking;
import Models.request.BookingDates;
import Models.response.IdClass;
import Models.response.Book;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class RequestSteps {
    StaticStrings staticStrings = new StaticStrings();
    Booking root = new Booking();
    Response createResponse;
    Response response;
    int id;
    IdClass idClass = new IdClass();
    Book book;



    @Step
    public RequestSteps addStrings(){
        BookingDates bookingDates = new BookingDates();
        bookingDates.checkin = staticStrings.checkin;
        bookingDates.checkout = staticStrings.checkout;
        root.firstname = staticStrings.firstname;
        root.lastname = staticStrings.lastname;
        root.totalprice = staticStrings.totalprice;
        root.depositpaid = true;
        root.additionalneeds = staticStrings.additionalneeds;
        root.bookingdates = bookingDates;
        return this;
    }
    @Step
    public RequestSteps postRequest(){
         createResponse = RestAssured.given()
                .baseUri(staticStrings.idURL)
                .contentType(ContentType.JSON)
                .body(root)
                .log()
                .body()
                .when()
                .post();
        return this;
    }

    @Step
    public RequestSteps getId(){
        id = createResponse.jsonPath().getInt("bookingid");
        idClass.setId(id);
        return this;
    }

    @Step
    public RequestSteps getRequest(){
         response = RestAssured.given()
                .when()
                .get(staticStrings.idURL + idClass.getId());
        return this;

    }

    @Step
    public RequestSteps getInClass() {
        if (response.statusCode() == 400) {
            System.out.println("error");
        } else if (response.statusCode() == 200) {
             book = response.as(Book.class);
        }
        return this;
    }

    @Step
    public RequestSteps validation(){
        assertThat(book.firstname, equalTo(root.firstname));
        assertThat(book.lastname,equalTo(root.lastname));
        assertThat(book.additionalneeds, equalTo(root.additionalneeds));
        return this;
    }

}
