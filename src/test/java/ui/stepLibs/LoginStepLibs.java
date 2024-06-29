package ui.stepLibs;

import net.serenitybdd.annotations.Step;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;
import ui.pages.HomePage;
import ui.pages.LoginPage;

public class LoginStepLibs {
    LoginPage loginPage;

    @Step("Navigate to login page")
    public void navigateToLoginPage() {
        loginPage.open();
    }

    @Step("Enter username")
    public void enterUsername(String username) {
        loginPage.enterUsername(username);
    }

    @Step("Enter password")
    public void enterPassword(String password) {
        loginPage.enterPassword(password);
    }

    @Step("Click login button")
    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }
}
