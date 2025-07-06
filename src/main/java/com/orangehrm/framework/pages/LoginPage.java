package com.orangehrm.framework.pages;

import com.orangehrm.framework.base.BasePage;
import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.qameta.allure.Step;
import org.testng.annotations.Listeners;

@Listeners({AllureTestNg.class})
public class LoginPage extends BasePage {
    // Constructor to initialize elements
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void waitForPageLoad() {

    }

    @Override
    public String getPageHeader() {
        return null;
    }

    @Override
    public boolean isPageLoaded() {
        return false;
    }

    // Locators
    @FindBy(name = "username")
    private WebElement usernameInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(css = "button[type='submit']")
    private WebElement loginButton;

    @FindBy(css = ".oxd-alert-content")  // error message locator
    private WebElement loginErrorMessage;

    // Methods

    /** Enter username */
    @Step("Enter user name")
    public void enterUsername(String username) {
        usernameInput.clear();
        usernameInput.sendKeys(username);
    }

    /** Enter password */
    @Step("Enter password")
    public void enterPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    /** Click login button */
    @Step("Click on login button")
    public void clickLogin() {
        loginButton.click();
    }

    /** Login with username and password */
    @Step("Login to app using username: {0} and password: {1}")
    public void login(String username, String password) {
        try {
            logger.info("🔐 Logging into the system");

            enterUsername(username);
            logger.info("✅ Entered username");

            enterPassword(password);
            logger.info("✅ Entered password");

            clickLogin();
            logger.info("🚀 Clicked on login button");

        } catch (Exception e) {
            logger.error("❌ Error while logging into the system", e);
        }

    }


    @Step("Get login error message")
    /** Get login error message text */
    public String getLoginErrorMessage() {
        if (loginErrorMessage.isDisplayed()) {
            return loginErrorMessage.getText();
        }
        return "";
    }
}
