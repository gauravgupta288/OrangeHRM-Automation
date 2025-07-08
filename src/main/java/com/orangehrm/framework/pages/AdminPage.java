package com.orangehrm.framework.pages;

import com.orangehrm.framework.base.BasePage;
import com.orangehrm.framework.helpers.UIHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdminPage extends BasePage {

    public AdminPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(css = ".oxd-form-row .oxd-input.oxd-input")
    private WebElement usernameInput;

    @Override
    public void waitForPageLoad() {
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(usernameInput));
            logger.info("Admin page loaded");
        }catch (NoSuchElementException e){
            logger.error("Error in loading Admin page", e);
        }
    }

    @Override
    public boolean isPageLoaded() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            return wait.until(ExpectedConditions.textToBePresentInElement(pageHeader, "Admin"));
        } catch (Exception e) {
            logger.info("Dashboard page not loaded");
            return false;
        }
    }
    public void clickOnAdminSidebar(){
        uiHelper.click(getSidebarByHeader("Admin"));
    }
}
