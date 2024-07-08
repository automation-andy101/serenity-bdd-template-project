package api.stepLibs;

import api.models.request.AuthTokenRequest;
import api.models.response.AuthTokenResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;
import io.restassured.response.Response;

public class RestRequestsStepLib {
    // Get the host url from the command line run argument
    private String hostUrl = System.getProperty("api.base.url");

    private final ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    // Access properties using Serenity's Configuration class
    EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
    private String adminUsername = environmentVariables.getProperty("restful.booker.api.admin.username");
    private String adminPassword = environmentVariables.getProperty("restful.booker.api.admin.password");

    private Response response;
    private static String token;

    private Response serenityGetTokenPostRequest() {
//        if (token == null) {
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

            return response = SerenityRest.given()
                    .contentType("application/json")
                    .post(requestBody)
                    .then()
                    .extract().response();
//            AuthTokenResponse authTokenResponse = mapper.readValue(response.getBody().asString(), AuthTokenResponse.class);
//            token = authTokenResponse.getToken();
//        }
//        return token;
    }

    private Response serenityRestGetRequest(String url, String token) {
        return RestAssured.given()
                .header("Cookie", "token=" + token)

    }

    public String getAuthTokenForAdminUser() throws JsonProcessingException {
        AuthTokenResponse authTokenResponse = mapper.readValue(serenityGetTokenPostRequest().getBody().asString(), AuthTokenResponse.class);

        return authTokenResponse.getToken();
    }

}
