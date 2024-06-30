package ui.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import net.serenitybdd.annotations.Steps;
import ui.stepLibs.AdminStepLibs;
import ui.stepLibs.CommonStepLibs;

public class AdminStepDefinition {

    @Steps
    AdminStepLibs adminStepLibs;

    @Given("user clicks Add button")
    public void userClicksAddButton() {
        adminStepLibs.clickAddButton();
    }

    @And("user enters {string}, {string}, {string}, {string} and {string}")
    public void userEntersNewUserDetails(String role, String name, String status, String username, String password) {
        adminStepLibs.userEntersNewUsersDetails(role, name, status, username, password);
    }
}
