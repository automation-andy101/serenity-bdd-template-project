package ui.stepLibs;

import net.serenitybdd.annotations.Step;
import org.junit.Assert;
import ui.pages.DashboardPage;
import ui.pages.LoginPage;
import ui.pages.NavPanelPage;

import static net.serenitybdd.core.Serenity.getDriver;

public class CommonStepLibs {
    LoginPage loginPage;
    NavPanelPage navPanelPage;

    public void login() {
        loginPage.open();
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLoginButton();
    }

    public void selectAdminMenuOption() {
        navPanelPage.selectAdminMenuOption();
    }
}
