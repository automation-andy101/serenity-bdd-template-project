package ui.pages;

import net.serenitybdd.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

@DefaultUrl("#HOST")
public class HomePage extends BasePage {

    private final By loginButton = By.id("signin");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickLoginButton() {
        clickOn(loginButton, Duration.ofSeconds(5));
    }
}
