package api.stepLibs;

import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;
import io.restassured.response.Response;

public class RestRequestsStepLib {
    private String hostUrl = System.getProperty("api.base.url");

    // Access properties using Serenity's Configuration class
    EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
    private String adminUsername = environmentVariables.getProperty("restful.booker.api.admin.username");
    private String adminPassword = environmentVariables.getProperty("restful.booker.api.admin.password");

    private Response response;

}
