package ui.stepLibs;

import net.serenitybdd.annotations.Step;
import org.junit.Assert;
import ui.pages.AdminPage;
import ui.pages.DashboardPage;
import ui.pages.LoginPage;

import java.util.Objects;

import static net.serenitybdd.core.Serenity.getDriver;

public class AdminStepLibs {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    AdminPage adminPage;

    @Step("Click Add button to create a new user")
    public void clickAddButton() {
        adminPage.clickAddButton();
    }

    public void userEntersNewUsersDetails(String role, String name, String status, String username, String password) {
        adminPage.openUserRoleDropdown();
        if (Objects.equals(role, "Admin")) adminPage.selectAdminOptionFromUserRoleDropdown();
        else adminPage.selectEssOptionFromUserRoleDropdown();

        adminPage.enterEmployeesName(name);
        adminPage.selectEmployeeName(name);

        adminPage.openStatusDropdown();
        if (Objects.equals(status, "Enabled")) adminPage.selectEnabledOptionFromStatusDropdown();
        else adminPage.selectDisabledOptionFromStatusDropdown();

        adminPage.enterUsername(username);
        adminPage.enterPassword(password);
        adminPage.enterConfirmPassword(password);
    }

    public void userClicksSaveButton() throws InterruptedException {
//        Thread.sleep(20000);
        adminPage.clickSaveButton();
        Thread.sleep(5000);
    }

    public void successToastPopupIsVisible() {
        Assert.assertTrue("Success toast popup did NOT appear", adminPage.isSuccessToastPopupVisible());
    }
}
