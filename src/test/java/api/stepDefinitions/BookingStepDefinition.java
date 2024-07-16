package api.stepDefinitions;

import api.stepLibs.BookingStepLibs;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.datatable.DataTable;
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

    @And("get bookings response status code is {int} OK")
    public void getBookingsResponseStatusCodeIsOK(int expectedStatusCode) {
        bookingStepLibs.validateGetBookingsResponseStatusCode(expectedStatusCode);
    }

    @Then("get booking by ID response status code is {int} OK")
    public void getBookingByIdResponseStatusCodeIsOK(int expectedStatusCode) {
        bookingStepLibs.validateGetBookingByIdResponseStatusCode(expectedStatusCode);
    }


    @Given("a new booking has been created with the following details:")
    public void aNewBookingHasBeenCreatedWithTheFollowingDetails(DataTable table) throws JsonProcessingException {
        bookingStepLibs.createNewBooking(table);
    }

    @When("I send a GET request to the Get Booking by ID endpoint with ID of the booking created in the previous step")
    public void iSendAGETRequestWithIDOfTheBookingCreatedInThePreviousStep() throws JsonProcessingException {
        bookingStepLibs.getBookingById();
    }

    @And("get booking by ID response body contains the following details:")
    public void getBookingByIdResponseBodyContainsTheFollowingDetails(DataTable table) {
        bookingStepLibs.validateGetBookingByIdResponseBodyContainsCorrectDetails(table);
    }


    @When("I send a POST request to create a new booking with the following details:")
    public void iSendAPOSTRequestToCreateANewBookingWithDetails(DataTable table) throws JsonProcessingException {
        bookingStepLibs.createNewBooking(table);
    }

    @Then("create new booking response status code is {int} OK")
    public void createNewBookingResponseStatusCodeIsOK(int expectedStatusCode) {
        bookingStepLibs.validateCreateNewBookingResponseStatusCode(expectedStatusCode);
    }

    @And("the response body should contain the following details:")
    public void theResponseBodyShouldContainTheFollowingDetails(DataTable table) {
        bookingStepLibs.validateCreateNewBookingResponseBodyContainsCorrectDetails(table);
    }

    @And("the booking ID should be present in the response")
    public void theBookingIDShouldBePresentInTheResponse() {
        bookingStepLibs.validateResponseContainsAnId();
    }
}
