package ui.stepLibs;

import net.serenitybdd.annotations.Step;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;
import ui.pages.HomePage;

public class LoginStepLibs {
    HomePage homePage;

    @Step("Open the home page")
    public void openHomePage() {
        EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
        String projectName = environmentVariables.getProperty("serenity.project.name");
        System.out.println("Serenity Project Name: " + projectName);
        homePage.open();
    }

    @Step("Navigate to login page")
    public void navigateToLoginPage() {
        homePage.clickLoginButton();
    }
}
