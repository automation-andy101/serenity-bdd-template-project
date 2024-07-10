package api.models.response;

import lombok.Data;

@Data
public class CreateBookingResponse {
    private int bookingid;
    private BookingDetails booking;
}
