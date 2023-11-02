package Models.request;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"firstname","lastname","totalprice","depositpaid","bookingdates","additionalneeds"})
@JsonIgnoreProperties({"salesprice"})
public class BookingLombok {
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

    private int salesprice;
    private String passportNo;

}
