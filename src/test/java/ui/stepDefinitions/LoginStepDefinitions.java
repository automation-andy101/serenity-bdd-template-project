package ui.stepDefinitions;

import io.cucumber.java.en.Given;
import net.serenitybdd.annotations.Steps;
import ui.stepLibs.LoginStepLibs;

public class LoginStepDefinitions {

    @Steps
    LoginStepLibs loginStepLibs;

    @Given("user is on the BrowserStack home page")
    public void userIsOnTheBrowserStackDemoHomePage() {
        loginStepLibs.openHomePage();
    }

    @Given("user navigate to the login page")
    public void userNavigateToTheLoginPage() {
        loginStepLibs.navigateToLoginPage();
    }
}
