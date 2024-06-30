package ui.pages;

import net.serenitybdd.annotations.At;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class NavPanelPage extends BasePage {

    private final By searchInput = By.xpath("//input[@placeholder='search']");
    private final By adminMenuOption = By.xpath("//span[text()='Admin']");
    private final By pimMenuOption = By.xpath("//span[text()='Admin']");
    private final By leaveMenuOption = By.xpath("//span[text()='Admin']");
    private final By timeMenuOption = By.xpath("//span[text()='Admin']");
    private final By recruitmentMenuOption = By.xpath("//span[text()='Admin']");
    private final By myInfoMenuOption = By.xpath("//span[text()='Admin']");
    private final By performanceMenuOption = By.xpath("//span[text()='Admin']");
    private final By dashboardMenuOption = By.xpath("//span[text()='Admin']");
    private final By directoryMenuOption = By.xpath("//span[text()='Admin']");
    private final By maintenanceMenuOption = By.xpath("//span[text()='Admin']");
    private final By claimMenuOption = By.xpath("//span[text()='Admin']");
    private final By buzzMenuOption = By.xpath("//span[text()='Admin']");

    public NavPanelPage(WebDriver driver) {
        super(driver);
    }

    public void selectAdminMenuOption() {
        clickOn(adminMenuOption, Duration.ofSeconds(5));
    }

    public void selectPimMenuOption() {
        clickOn(pimMenuOption, Duration.ofSeconds(5));
    }

    public void selectLeaveMenuOption() {
        clickOn(leaveMenuOption, Duration.ofSeconds(5));
    }

    public void selectTimeMenuOption() {
        clickOn(timeMenuOption, Duration.ofSeconds(5));
    }

    public void selectRecruitmentMenOption() {
        clickOn(recruitmentMenuOption, Duration.ofSeconds(5));
    }

    public void selectMyInfoMenuOption() {
        clickOn(myInfoMenuOption, Duration.ofSeconds(5));
    }

    public void selectPerformanceMenuOption() {
        clickOn(performanceMenuOption, Duration.ofSeconds(5));
    }

    public void selectDashboardMenuOption() {
        clickOn(dashboardMenuOption, Duration.ofSeconds(5));
    }

    public void selectDirectoryMenOption() {
        clickOn(directoryMenuOption, Duration.ofSeconds(5));
    }

    public void selectMaintenanceMenuOption() {
        clickOn(maintenanceMenuOption, Duration.ofSeconds(5));
    }

    public void selectClaimMenuOption() {
        clickOn(claimMenuOption, Duration.ofSeconds(5));
    }

    public void selectBuzzMenuOption() {
        clickOn(buzzMenuOption, Duration.ofSeconds(5));
    }
}
