package com.orangehrm.framework.pages;

import com.orangehrm.framework.base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage extends BasePage {
    public DashboardPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(css = ".oxd-userdropdown-tab")
    private WebElement userSettingBtn;
    @Override
    public void waitForPageLoad() {
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(userSettingBtn));
            logger.info("Dashboard page loaded");
        }catch (NoSuchElementException e){
            logger.error("Error in loading dashboard page", e);
        }


    }

    @Override
    public boolean isPageLoaded() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            return wait.until(ExpectedConditions.textToBePresentInElement(pageHeader, "Dashboard"));
        } catch (Exception e) {
            logger.info("Dashboard page not loaded");
            return false;
        }
    }

    public void handleAlerts() {


       Alert alert = driver.switchTo().alert();
    }

}
