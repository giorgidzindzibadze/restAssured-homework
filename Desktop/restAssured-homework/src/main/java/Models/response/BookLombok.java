package Models.response;

//import Models.request.BookingDates;
import Models.request.BookingDatesLombok;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonPropertyOrder({"firstname","lastname","totalprice","depositpaid","bookingdates","additionalneeds"})
public class BookLombok {
    @JsonProperty("firstname")
    private String firstName;
    @JsonProperty("lastname")
    private String lastName;
    @JsonProperty("totalprice")
    private int totalPrice;
    @JsonProperty("depositpaid")
    private boolean depositPaid;
    @JsonProperty("bookingdates")
    private BookingDatesLombok bookingDates;
    @JsonProperty("additionalneeds")
    private String additionalNeeds;

}
