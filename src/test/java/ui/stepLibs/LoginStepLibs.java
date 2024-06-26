package ui.stepLibs;

import net.serenitybdd.annotations.Step;
import ui.pages.HomePage;

public class LoginStepLibs {
    HomePage homePage;

    @Step("Open the home page")
    public void openHomePage() {
        homePage.open();
    }

    @Step("Navigate to login page")
    public void navigateToLoginPage() {
        homePage.clickLoginButton();
    }
}
