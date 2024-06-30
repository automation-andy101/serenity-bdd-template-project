package ui.stepLibs;

import net.serenitybdd.annotations.Step;
import org.junit.Assert;
import ui.pages.DashboardPage;
import ui.pages.LoginPage;

import java.net.MalformedURLException;
import java.net.URL;

import static net.serenitybdd.core.Serenity.getDriver;

public class LoginStepLibs {
    LoginPage loginPage;
    DashboardPage dashboardPage;

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

    @Step("Assert Dashboard header text is displayed")
    public void assertDashboardHeaderTextIsDisplayed() {
        Assert.assertTrue(dashboardPage.isDashboardHeaderTextDisplayed());
    }

    @Step("Verify user is navigated to the dashboard page")
    public void verifyCurrentUrlIsDashboardPage() {
        String expectedResourceUrl = "/dashboard/index";

        Assert.assertTrue("User was unsuccessfully navigated to the dashboard page", getDriver().getCurrentUrl().contains(expectedResourceUrl));
    }

    @Step("Verify user remains on login page")
    public void verifyCurrentUrlIsLoginPage() {
        String expectedResourceUrl = "/auth/login";

        Assert.assertTrue("User was incorrectly navigated away from the login page", getDriver().getCurrentUrl().contains(expectedResourceUrl));
    }

    @Step("Assert Invaid Credentials area is displayed")
    public void assertInvalidCredentialsAreaIsDisplayed() {
        Assert.assertTrue(loginPage.isInvalidCredentialsAreaDisplayed());
    }


}
