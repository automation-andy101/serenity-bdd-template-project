package api.stepLibs;

import api.models.request.AuthTokenRequest;
import api.models.request.CreateBookingRequest;
import api.models.response.*;
import api.testData.BookingTestData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;
import io.restassured.response.Response;

import java.util.List;

public class RestRequestsStepLib {
    // Get the host url from the command line run argument
    private String hostUrl = System.getProperty("api.base.url");

    private final ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    // Access properties using Serenity's Configuration class
    EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
    private String adminUsername = environmentVariables.getProperty("restful.booker.api.admin.username");
    private String adminPassword = environmentVariables.getProperty("restful.booker.api.admin.password");

    private Response response;
    private String token;

    private Response serenityGetTokenPostRequest(String url, String requestBody) {
            return response = SerenityRest.given()
                    .contentType("application/json")
                    .post(requestBody)
                    .then()
                    .extract().response();
    }

    private Response serenityRestGetRequest(String url, String token) {
        return RestAssured.given()
                .contentType("application/json")
                .header("Cookie", "token=" + token)
                .get(url)
                .then()
                .extract().response();
    }

    private Response serenityPostRequest(String url, Object requestBody, String token) {
        return response = SerenityRest.given()
                .contentType("application/json")
                .header("Cookie", "token=" + token)
                .body(requestBody)
                .post(url)
                .then()
                .extract().response();
    }

    private Response serenityRestPutRequest(String url, String requestBody, String token) {
        return RestAssured.given()
                .contentType("application/json")
                .header("Cookie", "token=" + token)
                .body(requestBody)
                .put(url)
                .then()
                .extract().response();
    }

    private Response serenityRestPatchRequest(String url, String requestBody, String token) {
        return RestAssured.given()
                .contentType("application/json")
                .header("Cookie", "token=" + token)
                .body(requestBody)
                .put(url)
                .then()
                .extract().response();
    }

    private Response serenityRestDeleteRequest(String url, String token) {
        return RestAssured.given()
                .contentType("application/json")
                .header("Cookie", "token=" + token)
                .delete(url)
                .then()
                .extract().response();
    }

    public String getAuthTokenForAdminUser() throws JsonProcessingException {
        if (token == null) {
            String url = hostUrl + environmentVariables.getProperty("get.token");

            AuthTokenRequest authTokenRequest = new AuthTokenRequest();
            authTokenRequest.setUsername(adminUsername);
            authTokenRequest.setPassword(adminPassword);

            ObjectMapper objectMapper = new ObjectMapper();
            String requestBody;

            try {
                requestBody = objectMapper.writeValueAsString(authTokenRequest);
            } catch (JsonProcessingException e) {
                throw new RuntimeException("Failed to serialize request body", e);
            }

            AuthTokenResponse authTokenResponse = mapper.readValue(serenityGetTokenPostRequest(url, requestBody).getBody().asString(), AuthTokenResponse.class);

            return authTokenResponse.getToken();
        } else {
            return token;
        }
    }

    public BookingIdsResponse getBookingIds() throws JsonProcessingException {
        String url = hostUrl + environmentVariables.getProperty("get.booking.ids");
        String token = getAuthTokenForAdminUser();

        return mapper.readValue(serenityRestGetRequest(url, token).getBody().asString(), BookingIdsResponse.class);
    }

    public BookingDetailsResponse getBookingById(int id) throws JsonProcessingException {
        String url = hostUrl + environmentVariables.getProperty("get.booking.by.id");
        url = url.replace("ID", Integer.toString(id));
        String token = getAuthTokenForAdminUser();

        return mapper.readValue(serenityRestGetRequest(url, token).getBody().asString(), BookingDetailsResponse.class);
    }

    public CreateBookingResponse createNewBooking(String firstname, String lastname, int totalprice, boolean depositpaid, String checkinDate, String checkoutDate, String additionalneeds) throws JsonProcessingException {
        String url = hostUrl + environmentVariables.getProperty("create.new.booking");
        String token = getAuthTokenForAdminUser();

        CreateBookingRequest createBookingRequest = BookingTestData.createBookingDetails();

        return mapper.readValue(serenityPostRequest(url, createBookingRequest, token).getBody().asString(), CreateBookingResponse.class)


    }
}
