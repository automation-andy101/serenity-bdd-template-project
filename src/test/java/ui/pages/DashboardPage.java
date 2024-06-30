package ui.pages;

import net.serenitybdd.annotations.At;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

@At(urls={"#HOST/web/index.php/dashboard/index"})
public class DashboardPage extends BasePage {

    private final By dashboardHeaderText = By.xpath("//h6[text()='Dashboard']");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDashboardHeaderTextDisplayed() {
        return isElementDisplayed(dashboardHeaderText, Duration.ofSeconds(5));
    }

}
