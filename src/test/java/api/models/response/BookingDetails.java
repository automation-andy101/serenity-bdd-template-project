package api.models.response;

import lombok.Data;

@Data
public class BookingDetails {
    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private BookingDates bookingdates;
    private String additionalneeds;
}
