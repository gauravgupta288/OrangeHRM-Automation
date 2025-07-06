package com.orangehrm.framework.base;

import com.orangehrm.framework.utils.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;

public abstract class BasePage {
    protected WebDriver driver;
    protected static final Logger logger = Log.getLogger(BasePage.class);

    @FindBy(css = ".oxd-topbar-header-breadcrumb")
    protected WebElement pageHeader;

    public String getPageHeader() {
        return pageHeader.getText();
    }

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public abstract void waitForPageLoad();

    public abstract boolean isPageLoaded();

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
