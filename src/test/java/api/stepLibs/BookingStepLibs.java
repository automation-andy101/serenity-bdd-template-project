package api.stepLibs;

import com.fasterxml.jackson.core.JsonProcessingException;
import net.serenitybdd.annotations.Step;
import org.junit.Assert;

import static net.serenitybdd.core.Serenity.getDriver;

public class BookingStepLibs {

    @Step("Request List of Bookings")
    public void requestListOfBookings() throws JsonProcessingException {
        RestRequestsStepLibs restRequestsStepLibs = new  RestRequestsStepLibs();
        restRequestsStepLibs.getBookingIds();
    }
}
