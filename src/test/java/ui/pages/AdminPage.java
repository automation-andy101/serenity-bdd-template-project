package ui.pages;

import net.serenitybdd.annotations.At;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

@At(urls={"#HOST/web/index.php/admin/viewSystemUsers"})
public class AdminPage extends BasePage {

    private final By addButton = By.xpath("//div[@class='orangehrm-header-container']/button");
    private final By userRoleDropDown = By.xpath("//label[text()='User Role']/parent::div/following-sibling::div");
    private final By adminDropdownMenuOption = By.xpath("//div[@class='oxd-select-option']/span[text()='Admin']");
    private final By essDropdownMenuOption = By.xpath("//div[@class='oxd-select-option']/span[text()='ESS']");
    private final By employeeNameInput = By.xpath("//input[@placeholder='Type for hints...']");
    private final By statusDropDown = By.xpath("//label[text()='Status']/parent::div/following-sibling::div");
    private final By enabledDropdownMenuOption = By.xpath("//div[@class='oxd-select-option']/span[text()='Enabled']");
    private final By disabledDropdownMenuOption = By.xpath("//div[@class='oxd-select-option']/span[text()='Disabled']");
    private final By usernameInput = By.xpath("//label[text()='Username']/parent::div/following-sibling::div/input");
    private final By passwordInput = By.xpath("//label[text()='Password']/parent::div/following-sibling::div/input");
    private final By confirmPasswordInput = By.xpath("//label[text()='Confirm Password']/parent::div/following-sibling::div/input");
    private final By saveButton = By.xpath("//button[text()=' Save ']");
    private final By toastPopup = By.id("oxd-toaster_1");
    private final By toastPopupSuccessText = By.xpath("//div[@class='oxd-toast-content oxd-toast-content--success']/p[text()='Success']");

    public AdminPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddButton() {
        clickOn(addButton, Duration.ofSeconds(5));
    }

    public void openUserRoleDropdown() {
        clickOn(userRoleDropDown, Duration.ofSeconds(5));
    }

    public void selectAdminOptionFromUserRoleDropdown() {
        clickOn(adminDropdownMenuOption, Duration.ofSeconds(5));
    }

    public void selectEssOptionFromUserRoleDropdown() {
        clickOn(essDropdownMenuOption, Duration.ofSeconds(5));
    }

    public void openStatusDropdown() {
        clickOn(statusDropDown, Duration.ofSeconds(5));
    }

    public void selectEnabledOptionFromStatusDropdown() {
        clickOn(enabledDropdownMenuOption, Duration.ofSeconds(5));
    }

    public void selectDisabledOptionFromStatusDropdown() {
        clickOn(disabledDropdownMenuOption, Duration.ofSeconds(5));
    }

    public void enterEmployeesName(String name) {
        typeInto(employeeNameInput, name, Duration.ofSeconds(5));
    }

    public void selectEmployeeName(String name) {
        String employeeNameXpath = "//span[text()='" + name + "']";
        By employeeNameSelection = By.xpath(employeeNameXpath);
        clickOn(employeeNameSelection, Duration.ofSeconds(5));
    }

    public void enterUsername(String username) {
        typeInto(usernameInput, username, Duration.ofSeconds(5));
    }

    public void enterPassword(String password) {
        typeInto(passwordInput, password, Duration.ofSeconds(5));
    }

    public void enterConfirmPassword(String password) {
        typeInto(confirmPasswordInput, password, Duration.ofSeconds(5));
    }

    public void clickSaveButton() {
        clickOn(saveButton, Duration.ofSeconds(5));
    }


    public boolean isSuccessToastPopupVisible() {
        return isElementDisplayed(toastPopup, Duration.ofSeconds(5));
    }
}