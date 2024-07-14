package api.testData;

import api.models.request.AuthTokenRequest;
import api.models.request.CreateBookingRequest;
import api.models.request.UpdateBookingRequest;
import api.models.response.BookingDates;

public class BookingTestData {
    public static AuthTokenRequest createAuthTokenRequestBody(String username, String password) {
        AuthTokenRequest authTokenRequest = new AuthTokenRequest();
        authTokenRequest.setUsername(username);
        authTokenRequest.setPassword(password);

        return authTokenRequest;
    }

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

    public static CreateBookingRequest createBookingDetails(String firstname, String lastname, int totalPrice, boolean depositPaid,
                                                            String checkinDate, String checkoutDate, String additionalNeeds) {
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

    public static UpdateBookingRequest updateBookingDetails() {
        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckin("2018-01-01");
        bookingDates.setCheckout("2019-01-01");

        UpdateBookingRequest updateBookingRequest = new UpdateBookingRequest();
        updateBookingRequest.setFirstname("Jim");
        updateBookingRequest.setLastname("Brown");
        updateBookingRequest.setTotalprice(111);
        updateBookingRequest.setDepositpaid(true);
        updateBookingRequest.setBookingdates(bookingDates);
        updateBookingRequest.setAdditionalneeds("Breakfast");

        return updateBookingRequest;
    }

    public static UpdateBookingRequest updateBookingDetails(String firstname, String lastname, int totalPrice, boolean depositPaid,
                                                            String checkinDate, String checkoutDate, String additionalNeeds) {
        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckin(checkinDate);
        bookingDates.setCheckout(checkoutDate);

        UpdateBookingRequest updateBookingRequest = new UpdateBookingRequest();
        updateBookingRequest.setFirstname(firstname);
        updateBookingRequest.setLastname(lastname);
        updateBookingRequest.setTotalprice(totalPrice);
        updateBookingRequest.setDepositpaid(depositPaid);
        updateBookingRequest.setBookingdates(bookingDates);
        updateBookingRequest.setAdditionalneeds(additionalNeeds);

        return updateBookingRequest;
    }
}
