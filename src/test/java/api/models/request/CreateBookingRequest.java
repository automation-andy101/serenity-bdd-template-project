package api.models.request;

import api.models.response.BookingDates;

import lombok.Data;

@Data
public class CreateBookingRequest {
    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private BookingDates bookingdates;
    private String additionalneeds;
}
