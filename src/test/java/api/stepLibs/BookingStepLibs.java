package api.stepLibs;

import api.models.response.BookingId;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.bs.A;
import net.serenitybdd.annotations.Step;
import org.apache.commons.lang3.tuple.Pair;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;

import java.util.List;

import static net.serenitybdd.core.Serenity.getDriver;
import static org.hamcrest.CoreMatchers.equalTo;

public class BookingStepLibs {

    Pair<List<BookingId>, Integer> bookingIdsResponse;

    @Step("Request List of Bookings")
    public void requestListOfBookings() throws JsonProcessingException {
        RestRequestsStepLibs restRequestsStepLibs = new  RestRequestsStepLibs();
        bookingIdsResponse = restRequestsStepLibs.getBookingIds();
    }

    @Step("Validate Response body contains a list of bookings")
    public void validateResponseBodyContainsBookings() {
        Assert.assertFalse(bookingIdsResponse.getLeft().isEmpty());
    }

    @Step("Validate Response status code is 200")
    public void validateResponseStatusCode(int expectedStatusCode) {
//        Assert.assertTrue(bookingIdsResponse.getRight().compareTo(200));
        MatcherAssert.assertThat(bookingIdsResponse.getRight(), equalTo(expectedStatusCode));
    }
}
