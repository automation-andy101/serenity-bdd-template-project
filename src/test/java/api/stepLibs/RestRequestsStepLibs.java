package api.stepLibs;

import api.models.request.AuthTokenRequest;
import api.models.request.CreateBookingRequest;
import api.models.request.UpdateBookingRequest;
import api.models.response.*;
import api.testData.BookingTestData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;
import io.restassured.response.Response;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;
import java.util.Map;

import static java.util.List.of;

public class RestRequestsStepLibs {
    // Get the host url from the command line run argument
//    private String hostUrl = System.getProperty("api.base.url");

    private final ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    // Access properties using Serenity's Configuration class
    EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
    private String adminUsername = environmentVariables.getProperty("restful.booker.api.admin.username");
    private String adminPassword = environmentVariables.getProperty("restful.booker.api.admin.password");
    private String hostUrl = environmentVariables.getProperty("restful.booker.api.env.dev.base.url");

    private Response response;
    private String token;

    private Response serenityGetTokenPostRequest(String url, Object requestBody) {
            return response = SerenityRest.given()
                    .log().all()
                    .contentType("application/json")
                    .body(requestBody)
                    .post(url)
                    .then()
                    .extract().response();
    }

//    private Response serenityRestGetRequest(String url, String token) {
//        return SerenityRest.given()
//                .contentType("application/json")
//                .header("Cookie", "token=" + token)
//                .get(url)
//                .then()
//                .extract().response();
//    }

    private Pair<Response, Integer> serenityRestGetRequest(String url, String token) {
         Response response = SerenityRest.given()
                 .log().all()
                 .contentType("application/json")
                 .header("Cookie", "token=" + token)
                 .get(url)
                 .then()
                 .extract().response();

        int statusCode = response.getStatusCode();

        return Pair.of(response, statusCode);
    }

//    private Response serenityPostRequest(String url, Object requestBody, String token) {
//        return response = SerenityRest.given()
//                .contentType("application/json")
//                .header("Cookie", "token=" + token)
//                .body(requestBody)
//                .post(url)
//                .then()
//                .extract().response();
//    }

    private Pair<Response, Integer> serenityPostRequest(String url, Object requestBody, String token) {
         Response response = SerenityRest.given()
                 .log().all()
                 .contentType("application/json")
                 .header("Cookie", "token=" + token)
                 .body(requestBody)
                 .post(url)
                 .then()
                 .extract().response();

         int statusCode = response.statusCode();

         return Pair.of(response, statusCode);
    }

//    private Response serenityRestPutRequest(String url, Object requestBody, String token) {
//        return SerenityRest.given()
//                .contentType("application/json")
//                .header("Cookie", "token=" + token)
//                .body(requestBody)
//                .put(url)
//                .then()
//                .extract().response();
//    }

    private Pair<Response, Integer> serenityRestPutRequest(String url, Object requestBody, String token) {
        Response response = SerenityRest.given()
                .log().all()
                .contentType("application/json")
                .header("Cookie", "token=" + token)
                .body(requestBody)
                .put(url)
                .then()
                .extract().response();

        int statusCode = response.getStatusCode();

        return Pair.of(response, statusCode);
    }

//    private Response serenityRestPatchRequest(String url, String requestBody, String token) {
//        return SerenityRest.given()
//                .contentType("application/json")
//                .header("Cookie", "token=" + token)
//                .body(requestBody)
//                .put(url)
//                .then()
//                .extract().response();
//    }

    private Pair<Response, Integer>  serenityRestPatchRequest(String url, String requestBody, String token) {
        Response response = SerenityRest.given()
                .log().all()
                .contentType("application/json")
                .header("Cookie", "token=" + token)
                .body(requestBody)
                .put(url)
                .then()
                .extract().response();

        int statusCode = response.getStatusCode();

        return Pair.of(response, statusCode);
    }

//    private Response serenityRestDeleteRequest(String url, String token) {
//        return SerenityRest.given()
//                .contentType("application/json")
//                .header("Cookie", "token=" + token)
//                .delete(url)
//                .then()
//                .extract().response();
//    }

    private Pair<Response, Integer> serenityRestDeleteRequest(String url, String token) {
        Response response = SerenityRest.given()
                .log().all()
                .contentType("application/json")
                .header("Cookie", "token=" + token)
                .delete(url)
                .then()
                .extract().response();

        int statusCode = response.getStatusCode();

        return Pair.of(response, statusCode);
    }

    public String getAuthTokenForAdminUser() throws JsonProcessingException {
        if (token == null) {
            String url = hostUrl + environmentVariables.getProperty("get.token");
            AuthTokenRequest authTokenRequest = BookingTestData.createAuthTokenRequestBody(adminUsername, adminPassword);
            AuthTokenResponse authTokenResponse = mapper.readValue(serenityGetTokenPostRequest(url, authTokenRequest).getBody().asString(), AuthTokenResponse.class);
            return authTokenResponse.getToken();
        } else {
            return token;
        }
    }

    public Pair<List<BookingId>, Integer> getBookingIds() throws JsonProcessingException {
        String url = hostUrl + environmentVariables.getProperty("get.booking.ids");
        String token = getAuthTokenForAdminUser();

        Pair<Response, Integer> responsePair = serenityRestGetRequest(url, token);
        Response response = responsePair.getLeft();
        int statusCode = responsePair.getRight();

//        List<BookingId> bookingIdsResponse = mapper.readValue(response.getBody().asString(), BookingIdsResponse.class);
        List<BookingId> bookingIdsResponse = mapper.readValue(response.getBody().asString(), new TypeReference<List<BookingId>>(){});
//        List<BookingId> bookingIdsResponse = List.of(mapper.readValue(response.getBody().asString(), BookingIdsResponse.class).getBookingIds());
//        List<BookingId> bookingIdsResponse = mapper.readValue(response.getBody().asString(), BookingIdsResponse.class);

        System.out.println("CHIPS AND BEANS - ");
        System.out.println(bookingIdsResponse.get(1).toString());

        return  Pair.of(bookingIdsResponse, statusCode);
    }

//    public BookingDetailsResponse getBookingById(int id) throws JsonProcessingException {
//        String url = hostUrl + environmentVariables.getProperty("get.booking.by.id");
//        url = url.replace("ID", Integer.toString(id));
//        String token = getAuthTokenForAdminUser();
//
//        return mapper.readValue(serenityRestGetRequest(url, token).getBody().asString(), BookingDetailsResponse.class);
//    }

    public Pair<BookingDetailsResponse, Integer> getBookingById(int id) throws JsonProcessingException {
        String url = hostUrl + environmentVariables.getProperty("get.booking.by.id");
        url = url.replace("ID", Integer.toString(id));
        String token = getAuthTokenForAdminUser();

        Pair<Response, Integer> responsePair = serenityRestGetRequest(url, token);
        Response response = responsePair.getLeft();
        int statusCode = responsePair.getRight();

        BookingDetailsResponse bookingDetails = mapper.readValue(response.getBody().asString(), BookingDetailsResponse.class);
        return Pair.of(bookingDetails, statusCode);
    }

//    public CreateBookingResponse createNewBooking(String firstname, String lastname, int totalPrice, boolean depositPaid, String checkinDate, String checkoutDate, String additionalNeeds) throws JsonProcessingException {
//        String url = hostUrl + environmentVariables.getProperty("create.new.booking");
//        String token = getAuthTokenForAdminUser();
//
//        CreateBookingRequest createBookingRequest = BookingTestData.createBookingDetails(firstname, lastname, totalPrice, depositPaid, checkinDate, checkoutDate, additionalNeeds);
//
//        return mapper.readValue(serenityPostRequest(url, createBookingRequest, token).getBody().asString(), CreateBookingResponse.class);
//    }

    public Pair<CreateBookingResponse, Integer> createNewBooking(String firstname, String lastname, int totalPrice, boolean depositPaid, String checkinDate, String checkoutDate, String additionalNeeds) throws JsonProcessingException {
        String url = hostUrl + environmentVariables.getProperty("create.new.booking");
        String token = getAuthTokenForAdminUser();

        CreateBookingRequest createBookingRequest = BookingTestData.createBookingDetails(firstname, lastname, totalPrice, depositPaid, checkinDate, checkoutDate, additionalNeeds);

        Pair<Response, Integer> responsePair = serenityPostRequest(url, createBookingRequest, token);
        Response response = responsePair.getLeft();
        int statusCode = responsePair.getRight();

        CreateBookingResponse createBookingResponse = mapper.readValue(response.getBody().asString(), CreateBookingResponse.class);
        return  Pair.of(createBookingResponse, statusCode);
    }

//    public void deleteBooking(int id) throws JsonProcessingException {
//        String url = hostUrl + environmentVariables.getProperty("delete.booking");
//        String token = getAuthTokenForAdminUser();
//
//
//    }

    public Pair<UpdateBookingResponse, Integer> updateBooking(int id, String firstname, String lastname, int totalPrice, boolean depositPaid, String checkinDate, String checkoutDate, String additionalNeeds) throws JsonProcessingException {
        String url = hostUrl + environmentVariables.getProperty("update.booking");
        url = url.replace("ID", Integer.toString(id));

        String token = getAuthTokenForAdminUser();

        UpdateBookingRequest updateBookingRequest = BookingTestData.updateBookingDetails(firstname, lastname, totalPrice, depositPaid, checkinDate, checkoutDate, additionalNeeds);

        Pair<Response, Integer> responsePair = serenityRestPutRequest(url, updateBookingRequest, token);
        Response response = responsePair.getLeft();
        int statusCode = responsePair.getRight();

        UpdateBookingResponse updateBookingResponse = mapper.readValue(response.getBody().asString(), UpdateBookingResponse.class);

        return Pair.of(updateBookingResponse, statusCode);
    }

    public Pair<UpdateBookingResponse, Integer> partialUpdateBooking(int id, Map<String, Object> partialUpdateFields) throws JsonProcessingException {
        String url = hostUrl + environmentVariables.getProperty("partial.update.booking");
        url = url.replace("ID", Integer.toString(id));

        String token = getAuthTokenForAdminUser();
//        UpdateBookingRequest updateBookingRequest = BookingTestData.updateBookingDetails(firstname, lastname, totalPrice, depositPaid, checkinDate, checkoutDate, additionalNeeds);

        Pair<Response, Integer> responsePair = serenityRestPutRequest(url, partialUpdateFields, token);
        Response response = responsePair.getLeft();
        int statusCode = responsePair.getRight();

        UpdateBookingResponse updateBookingResponse = mapper.readValue(response.getBody().asString(), UpdateBookingResponse.class);

        return Pair.of(updateBookingResponse, statusCode);
    }

    public Pair<Response, Integer> deleteBooking(int id) throws JsonProcessingException {
        String url = hostUrl + environmentVariables.getProperty("delete.booking");
        String token = getAuthTokenForAdminUser();

        Pair<Response, Integer> responsePair = serenityRestDeleteRequest(url, token);
        Response response = responsePair.getLeft();
        int statusCode = responsePair.getRight();

        return  Pair.of(response, statusCode);
    }
}
