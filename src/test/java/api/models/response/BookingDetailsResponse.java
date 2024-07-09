package api.models.response;

import lombok.Data;

@Data
public class BookingDetailsResponse {
    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private BookingDates bookingdates;
}
