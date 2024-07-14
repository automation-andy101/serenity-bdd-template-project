package api.models.response;

import lombok.Data;

import java.util.List;

@Data
public class BookingIdsResponse {
//    private List<BookingId> bookingIds;
    private BookingId[] bookingIds;
}
