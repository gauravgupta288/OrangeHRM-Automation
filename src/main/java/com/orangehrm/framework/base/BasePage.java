package com.orangehrm.framework.base;

import com.orangehrm.framework.helpers.UIHelper;
import com.orangehrm.framework.utils.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;

import java.util.List;

public abstract class BasePage {
    protected WebDriver driver;
    protected UIHelper uiHelper;
    protected static final Logger logger = Log.getLogger(BasePage.class);

    @FindBy(css = ".oxd-topbar-header-breadcrumb")
    protected WebElement pageHeader;

    protected By getSidebarByHeader(String header) {
        String xpath = String.format("//*[contains(@class, 'oxd-text oxd-text--span') and text()='%s']", header);
        return By.xpath(xpath);
    }


    public String getPageHeader() {
        return pageHeader.getText();
    }

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.uiHelper = new UIHelper(driver);
    }

    public abstract void waitForPageLoad();

    public abstract boolean isPageLoaded();

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    // Generic method to fetch column data by column name
    public List<String> getTableData(String columnName){
        return uiHelper.getTableColumnData(columnName);
    }

    public void sortColumn(String columnName, boolean asc){
        String headerXpath  = String.format("//*[contains(@class,'oxd-table-header-cell') and text()='%s']", columnName);
        By sortIconLocator = By.xpath(headerXpath + "//div[@class='oxd-table-header-sort']");

        uiHelper.click(sortIconLocator);

        By ascLocator = By.xpath(headerXpath + "//i[@class='oxd-icon bi-sort-alpha-down']");
        By descLocator = By.xpath(headerXpath + "//i[@class='oxd-icon bi-sort-alpha-up']");

        uiHelper.click(
                asc ? ascLocator : descLocator
        );
    }
}
