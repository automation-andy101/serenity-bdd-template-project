package api.testData;

import api.models.request.CreateBookingRequest;
import api.models.response.BookingDates;

public class BookingTestData {
    public static CreateBookingRequest createBookingDetails() {
        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckin("2018-01-01");
        bookingDates.setCheckout("2019-01-01");

        CreateBookingRequest createBookingRequest = new CreateBookingRequest();
        createBookingRequest.setFirstname("Jim");
        createBookingRequest.setLastname("Brown");
        createBookingRequest.setTotalprice(111);
        createBookingRequest.setDepositpaid(true);
        createBookingRequest.setBookingdates(bookingDates);
        createBookingRequest.setAdditionalneeds("Breakfast");

        return createBookingRequest;
    }

    public static CreateBookingRequest createBookingDetails(String checkinDate, String checkoutDate, String firstname, String lastname,
                                                      int totalPrice, boolean depositPaid, String additionalNeeds) {
        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckin(checkinDate);
        bookingDates.setCheckout(checkoutDate);

        CreateBookingRequest createBookingRequest = new CreateBookingRequest();
        createBookingRequest.setFirstname(firstname);
        createBookingRequest.setLastname(lastname);
        createBookingRequest.setTotalprice(totalPrice);
        createBookingRequest.setDepositpaid(depositPaid);
        createBookingRequest.setBookingdates(bookingDates);
        createBookingRequest.setAdditionalneeds(additionalNeeds);

        return createBookingRequest;
    }
}
