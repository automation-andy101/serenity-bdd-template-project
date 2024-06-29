package ui.pages;

import net.serenitybdd.annotations.At;
import net.serenitybdd.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

@At(urls={"#HOST/web/index.php/auth/login"})
public class LoginPage extends BasePage {

    private final By usernameInput = By.name("username");
    private final By passwordInput = By.name("password");
    private final By loginButton = By.xpath("//button[@type='submit']");
    private final By invalidCredentialsArea = By.xpath("//div[@role='alert']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String username) {
        typeInto(usernameInput, username, Duration.ofSeconds(5));
    }

    public void enterPassword(String password) {
        typeInto(passwordInput, password, Duration.ofSeconds(5));
    }

    public void clickLoginButton() {
        clickOn(loginButton, Duration.ofSeconds(5));
    }

    public boolean isInvalidCredentialsAreaDisplayed() {
        return isElementDisplayed(invalidCredentialsArea, Duration.ofSeconds(5));
    }

}
