package ui.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import ui.stepLibs.LoginStepLibs;

import static net.serenitybdd.core.Serenity.getDriver;

public class LoginStepDefinitions {

    @Steps
    LoginStepLibs loginStepLibs;

    @Given("user is on the Orange HRM Live login page")
    public void userIsOnTheOrangeHrmLiveLoginPage() {
        loginStepLibs.navigateToLoginPage();
    }

    @When("user enters {string} into the username input field")
    public void userEntersUsername(String username) {
        loginStepLibs.enterUsername(username);
    }

    @And("user enters {string} into the password input field")
    public void userEntersPassword(String password) {
        loginStepLibs.enterPassword(password);
    }

    @And("clicks Login button")
    public void clickLoginButton() {
        loginStepLibs.clickLoginButton();
    }

    @And("user is successfully logged into the app")
    public void verifyCurrentUrlIsDashboard() {
        loginStepLibs.verifyCurrentUrlIsDashboardPage();
    }

    @Then("user is not logged into the app")
    public void assertUserRemainsOnLoginPage() {
        loginStepLibs.verifyCurrentUrlIsLoginPage();
    }

    @And("dashboard header text is visible")
    public void dashboardIsVisible() {
        loginStepLibs.assertDashboardHeaderTextIsDisplayed();
    }

    @And("invalid credentials area is visible")
    public void invalidCredentialsAreaIsVisible() {
        loginStepLibs.assertInvalidCredentialsAreaIsDisplayed();
    }
}
