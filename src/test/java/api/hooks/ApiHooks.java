package api.hooks;


import api.models.response.CreateBookingResponse;
import api.stepLibs.BookingStepLibs;
import api.stepLibs.RestRequestsStepLibs;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.response.Response;
import net.serenitybdd.annotations.Steps;
import org.apache.commons.lang3.tuple.Pair;

public class ApiHooks {
    public static int id;

    @Before("@createBookingBeforeHook")
    public void createBookingBeforeTest() throws JsonProcessingException {
        int id = 0;

        RestRequestsStepLibs restRequestsStepLibs = new  RestRequestsStepLibs();
        Pair<CreateBookingResponse, Integer> beforeHookBooking = restRequestsStepLibs.createNewBooking("testFirstname",
                "testLastname", 200, true, "2024-07-14", "2024-07-21", "Breakfast");

        id = beforeHookBooking.getLeft().getBookingid();
    }

    @After("@deleteBookingAfterHook")
    public void deleteBookingAfterTest() throws JsonProcessingException {
        RestRequestsStepLibs restRequestsStepLibs = new  RestRequestsStepLibs();
        Pair<Response, Integer> afterHookBooking = restRequestsStepLibs.deleteBooking(id);
    }
}
