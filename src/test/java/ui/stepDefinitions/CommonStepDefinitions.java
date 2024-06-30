package ui.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import ui.stepLibs.CommonStepLibs;
import ui.stepLibs.LoginStepLibs;

public class CommonStepDefinitions {

    @Steps
    CommonStepLibs commonStepLibs;

    @Given("user has successfully logged in")
    public void userHasSuccessfullyLoggedIn() {
        commonStepLibs.login();
    }

    @And("is on the Admin page")
    public void isOnTheAdminPage() {
        commonStepLibs.selectAdminMenuOption();
    }

}
