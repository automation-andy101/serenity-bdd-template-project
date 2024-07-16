package api.stepLibs;

import api.hooks.ApiHooks;
import api.models.request.CreateBookingRequest;
import api.models.response.BookingDetailsResponse;
import api.models.response.BookingId;
import api.models.response.CreateBookingResponse;
import api.testData.BookingTestData;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.bs.A;
import net.serenitybdd.annotations.Step;
import org.apache.commons.lang3.tuple.Pair;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Assert;
import java.util.List;
import java.util.Map;
import static org.hamcrest.CoreMatchers.equalTo;

public class BookingStepLibs {

    public Pair<List<BookingId>, Integer> bookingIdsResponse;
    public Pair<CreateBookingResponse, Integer> createNewBookingResp;
    public Pair<BookingDetailsResponse, Integer> getBookingByIdResp;
    public int newBookingId;

    @Step("Request List of Bookings")
    public void requestListOfBookings() throws JsonProcessingException {
        RestRequestsStepLibs restRequestsStepLibs = new  RestRequestsStepLibs();
        bookingIdsResponse = restRequestsStepLibs.getBookingIds();
    }

    @Step("Validate Response body contains a list of bookings")
    public void validateResponseBodyContainsBookings() {
        Assert.assertFalse(bookingIdsResponse.getLeft().isEmpty());
    }

    @Step("Validate Get Bookings Response status code is 200")
    public void validateGetBookingsResponseStatusCode(int expectedStatusCode) {
        MatcherAssert.assertThat(bookingIdsResponse.getRight(), equalTo(expectedStatusCode));
    }

    @Step("Create a new booking")
    public void createNewBooking(DataTable dataTable) throws JsonProcessingException {
        Map<String, String> bookingDetails = dataTable.asMap(String.class, String.class);

        CreateBookingRequest newBookingPayload = BookingTestData.createBookingDetails(
                bookingDetails.get("firstname"),
                bookingDetails.get("lastname"),
                Integer.parseInt(bookingDetails.get("totalprice")),
                Boolean.parseBoolean(bookingDetails.get("depositpaid")),
                bookingDetails.get("checkin"),
                bookingDetails.get("checkout"),
                bookingDetails.get("additionalneeds")
        );

        RestRequestsStepLibs restRequestsStepLibs = new RestRequestsStepLibs();
        createNewBookingResp = restRequestsStepLibs.createNewBooking(newBookingPayload);
        newBookingId = createNewBookingResp.getLeft().getBookingid();
        ApiHooks.bookingId = newBookingId;
    }

    @Step("Get booking by ID")
    public void getBookingById() throws JsonProcessingException {
        RestRequestsStepLibs restRequestsStepLibs = new RestRequestsStepLibs();
        getBookingByIdResp = restRequestsStepLibs.getBookingById(newBookingId);
    }

    @Step("Validate Get Booking By id Response status code is 200")
    public void validateGetBookingByIdResponseStatusCode(int expectedStatusCode) {
        MatcherAssert.assertThat(getBookingByIdResp.getRight(), equalTo(expectedStatusCode));
    }

    @Step("Validate Get Booking By id Response Body contains the correct details")
    public void validateGetBookingByIdResponseBodyContainsCorrectDetails(DataTable dataTable) {
        Map<String, String> bookingDetails = dataTable.asMap(String.class, String.class);

        MatcherAssert.assertThat(getBookingByIdResp.getLeft().getFirstname(), equalTo(bookingDetails.get("firstname")));
        MatcherAssert.assertThat(getBookingByIdResp.getLeft().getLastname(), equalTo(bookingDetails.get("lastname")));
        MatcherAssert.assertThat(getBookingByIdResp.getLeft().getTotalprice(), equalTo(Integer.parseInt(bookingDetails.get("totalprice"))));
        MatcherAssert.assertThat(getBookingByIdResp.getLeft().isDepositpaid(), equalTo(Boolean.parseBoolean(bookingDetails.get("depositpaid"))));
        MatcherAssert.assertThat(getBookingByIdResp.getLeft().getBookingdates().getCheckin(), equalTo(bookingDetails.get("checkin")));
        MatcherAssert.assertThat(getBookingByIdResp.getLeft().getBookingdates().getCheckout(), equalTo(bookingDetails.get("checkout")));
        MatcherAssert.assertThat(getBookingByIdResp.getLeft().getAdditionalneeds(), equalTo(bookingDetails.get("additionalneeds")));
    }

    @Step("Validate Create New Booking Response status code is 200")
    public void validateCreateNewBookingResponseStatusCode(int expectedStatusCode) {
        MatcherAssert.assertThat(createNewBookingResp.getRight(), equalTo(expectedStatusCode));
    }

    @Step("Validate Create New Booking Response Body contains the correct details")
    public void validateCreateNewBookingResponseBodyContainsCorrectDetails(DataTable dataTable) {
        Map<String, String> bookingDetails = dataTable.asMap(String.class, String.class);

        MatcherAssert.assertThat(createNewBookingResp.getLeft().getBooking().getFirstname(), equalTo(bookingDetails.get("firstname")));
        MatcherAssert.assertThat(createNewBookingResp.getLeft().getBooking().getLastname(), equalTo(bookingDetails.get("lastname")));
        MatcherAssert.assertThat(createNewBookingResp.getLeft().getBooking().getTotalprice(), equalTo(Integer.parseInt(bookingDetails.get("totalprice"))));
        MatcherAssert.assertThat(createNewBookingResp.getLeft().getBooking().isDepositpaid(), equalTo(Boolean.parseBoolean(bookingDetails.get("depositpaid"))));
        MatcherAssert.assertThat(createNewBookingResp.getLeft().getBooking().getBookingdates().getCheckin(), equalTo(bookingDetails.get("checkin")));
        MatcherAssert.assertThat(createNewBookingResp.getLeft().getBooking().getBookingdates().getCheckout(), equalTo(bookingDetails.get("checkout")));
        MatcherAssert.assertThat(createNewBookingResp.getLeft().getBooking().getAdditionalneeds(), equalTo(bookingDetails.get("additionalneeds")));
    }

    @Step("Validate response contains an ID")
    public void validateResponseContainsAnId() {
        MatcherAssert.assertThat(createNewBookingResp.getLeft().getBookingid(), Matchers.notNullValue());
    }
}
