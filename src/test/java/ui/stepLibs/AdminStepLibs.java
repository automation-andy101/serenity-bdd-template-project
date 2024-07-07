package ui.stepLibs;

import net.serenitybdd.annotations.Step;
import org.junit.Assert;
import ui.pages.AdminPage;
import ui.pages.DashboardPage;
import ui.pages.LoginPage;
import ui.utils.UIUtilityClass;

import java.util.Objects;

import static net.serenitybdd.core.Serenity.getDriver;

public class AdminStepLibs {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    AdminPage adminPage;

    String uniqueUsername = "";

    @Step("Click Add button to create a new user")
    public void clickAddButton() {
        adminPage.clickAddButton();
    }

    @Step("Enter details for a new user")
    public void entersNewUsersDetails(String role, String name, String status, String username, String password) throws InterruptedException {
        adminPage.openUserRoleDropdown();
        if (Objects.equals(role, "Admin")) adminPage.selectAdminOptionFromUserRoleDropdown();
        else adminPage.selectEssOptionFromUserRoleDropdown();

        adminPage.enterEmployeesName(name);
        adminPage.selectEmployeeName(name);

        adminPage.openStatusDropdown();
        if (Objects.equals(status, "Enabled")) adminPage.selectEnabledOptionFromStatusDropdown();
        else adminPage.selectDisabledOptionFromStatusDropdown();

        uniqueUsername = username + UIUtilityClass.generateUniqueRandomNumber();
        adminPage.enterUsername(uniqueUsername);
        adminPage.enterPassword(password);
        adminPage.enterConfirmPassword(password);
    }

    public void userClicksSaveButton() {
        adminPage.clickSaveButton();
    }

    public void successToastPopupIsVisible() {
        Assert.assertTrue("Success toast popup did NOT appear", adminPage.isSuccessToastPopupVisible());
    }

    public void searchForUser(String name, String username, String role, String status) throws InterruptedException {
//        adminPage.toggleSearchArea();
        System.out.println("EGG");
        System.out.println(uniqueUsername);
        adminPage.enterSearchUsername(uniqueUsername);

//        adminPage.clickSearchUserRoleDropDown();
//        adminPage.selectOptionFromSearchUserRoleDropDown(role);
//        adminPage.enterSearchEmployeeName(name);
//        adminPage.clickSearchStatusDropDown();
//        adminPage.selectOptionFromSearchstatusDropDown(status);
        Thread.sleep(5000);
//        adminPage.clickSearchButton();
    }

    public void newUserCardAppearsContainingCorrectInfo() {

    }
}
