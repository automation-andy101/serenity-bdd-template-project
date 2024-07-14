package api.stepDefinitions;

import api.stepLibs.BookingStepLibs;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class BookingStepDefinition {

    @Steps
    BookingStepLibs bookingStepLibs;

    @Given("I am an authenticated user")
    public void iAmAnAuthenticatedUser() {

    }

    @When("I send a GET request to the bookings API endpoint")
    public void iSendAGetRequestToTheBookingsApiEndpoint() throws JsonProcessingException {
        bookingStepLibs.requestListOfBookings();
    }

    @Then("I receive a list of all bookings")
    public void iReceiveAListOfBookings() throws JsonProcessingException {
        bookingStepLibs.validateResponseBodyContainsBookings();
    }

    @And("the response status should be {int} OK")
    public void theResponseStatusShouldBeOK(int expectedStatusCode) {
        bookingStepLibs.validateResponseStatusCode(expectedStatusCode);
    }


}
