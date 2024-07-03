package ui.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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
    public void userEntersNewUserDetails(String role, String name, String status, String username, String password)  {
        adminStepLibs.entersNewUsersDetails(role, name, status, username, password);
    }

    @When("user clicks Save button")
    public void userClicksSaveButton() {
        adminStepLibs.userClicksSaveButton();
    }

    @Then("Success toast popup appears")
    public void successToastPopupIsVisible() {
        adminStepLibs.successToastPopupIsVisible();
    }

    @And("new user card appears containing {string}, {string}, {string} and {string}")
    public void newUserCardAppearsContainingCorrectInfo(String name, String username, String role, String status) throws InterruptedException {
        adminStepLibs.searchForUser(name, username, role, status);
        adminStepLibs.newUserCardAppearsContainingCorrectInfo();
    }
}
