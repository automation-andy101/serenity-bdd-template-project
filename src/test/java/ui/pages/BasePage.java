package ui.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.*;

import java.time.Duration;

public class BasePage extends PageObject {
    public BasePage(WebDriver driver) {
        super(driver);
        driver.manage().window().maximize();
    }

    // Common method to open a URL
    public void navigateTo(String url) {
        getDriver().get(url);
    }

    /**
     * Clicks on a web element located by the specified locator within a given timeout.
     *
     * @param locator the locator used to find the web element
     * @param timeout the maximum time to wait for the element to become clickable
     * @throws NoSuchElementException if the element cannot be found
     * @throws TimeoutException if the element is not clickable within the specified timeout
     * @see org.openqa.selenium.By
     * @see java.time.Duration
     */
    // Common method to click on an element
    public void clickOn(By locator, Duration timeout) {
        $(locator).withTimeoutOf(timeout).click();
    }

    // Common method to find an element by its locator
    public WebElementFacade find(By locator, Duration timeout) {
        return $(locator).withTimeoutOf(timeout);
    }

    // Custom wait for an element to be visible with a specific timeout
    public void waitForElementToBeVisible(By locator, Duration timeout) {
        $(locator).withTimeoutOf(timeout).waitUntilVisible();
    }

    /**
     * checks if a web element is displayed on the page within a given timeout.
     *
     * @param locator the locator used to find the web element
     * @param timeout the maximum time to wait for the element to become displayed
     * @throws NoSuchElementException if the element cannot be found
     * @throws TimeoutException if the element is not displayed within the specified timeout
     * @see org.openqa.selenium.By
     * @see java.time.Duration
     */
    // Common method to check if an element is displayed
    public boolean isElementDisplayed(By locator, Duration timeout) {
        return $(locator).withTimeoutOf(timeout).isDisplayed();
    }

    /**
     * checks if a web element is visible on the page within a given timeout.
     * @param locator the locator used to find the web element
     * @param timeout the maximum time to wait for the element to become clickable
     * @throws NoSuchElementException if the element cannot be found
     * @throws TimeoutException if the element is not clickable within the specified timeout
     * @see org.openqa.selenium.By
     * @see java.time.Duration
     */
    // Common method to check if an element is displayed
    public boolean isElementVisible(By locator, Duration timeout) {
        return $(locator).withTimeoutOf(timeout).isVisible();
    }

    /**
     * Enter text into a web element located by the specified locator within a given timeout.
     *
     * @param locator the locator used to find the web element
     * @param text the text a user wants to enter into the web element
     * @param timeout the maximum time to wait for the element to become clickable
     * @throws NoSuchElementException if the element cannot be found
     * @throws TimeoutException if the element is not clickable within the specified timeout
     * @see org.openqa.selenium.By
     * @see java.time.Duration
     */
    // Common method to type text into an element
    public void typeInto(By locator, String text, Duration timeout) {
        $(locator).withTimeoutOf(timeout).type(text);
    }

    /**
     * Enter text into a web element located by the specified locator within a given timeout.
     *
     * @param locator the locator used to find the web element
     * @param text the text a user wants to enter into the web element
     * @param timeout the maximum time to wait for the element to become clickable
     * @throws NoSuchElementException if the element cannot be found
     * @throws TimeoutException if the element is not clickable within the specified timeout
     * @see org.openqa.selenium.By
     * @see java.time.Duration
     */
    // Common method to type text into an element
    public void typeIntoUsingJavascriptExecutor (By locator, String text, Duration timeout) {
        // Use JavaScript to click the element
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].value='" + text + "';", $(locator).withTimeoutOf(timeout));

//        // Optionally, you can add some delay to see the click action
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        $(locator).withTimeoutOf(timeout).type(text);
    }

    // Common method to get text from an element
    public String getTextFromElement(By locator, Duration timeout) {
        return $(locator).withTimeoutOf(timeout).getText();
//        return find(locator).withTimeoutOf(timeout).getText();
    }
}
