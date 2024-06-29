package ui.pages;

import net.serenitybdd.annotations.At;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

@At("#HOST")
public class LoginPage extends BasePage {

    private final By usernameInput = By.name("username");
    private final By passwordInput = By.name("password");
    private final By loginButton = By.xpath("//button[text()=' Login ']");

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



}
