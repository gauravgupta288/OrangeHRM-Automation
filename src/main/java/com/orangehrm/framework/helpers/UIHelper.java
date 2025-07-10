package com.orangehrm.framework.helpers;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class UIHelper {

    private WebDriver driver;

    public UIHelper(WebDriver driver) {
        this.driver = driver;
    }

    // Click element
    public void click(By locator) {
        waitForElementToBeClickable(locator).click();
    }

    // Enter text
    public void enterText(By locator, String text) {
        WebElement element = waitForElementToBeVisible(locator);
        element.clear();
        element.sendKeys(text);
    }

    // Get text from element
    public String getText(By locator) {
        return waitForElementToBeVisible(locator).getText();
    }

    // Wait for element
    public WebElement waitForElementToBeVisible(By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForElementToBeClickable(By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    // Select dropdown by visible text
    public void selectDropdownByText(By locator, String visibleText) {
        Select dropdown = new Select(waitForElementToBeVisible(locator));
        dropdown.selectByVisibleText(visibleText);
    }

    public void selectDropdownByIndex(By locator, int visibleText) {
        Select dropdown = new Select(waitForElementToBeVisible(locator));
        dropdown.selectByIndex(visibleText);
    }

    public void selectDropdownByValue(By locator, String visibleText) {
        Select dropdown = new Select(waitForElementToBeVisible(locator));
        dropdown.selectByValue(visibleText);
    }

    // Get all cell values from column by header name (used for tables like OrangeHRM)
    public List<String> getTableColumnData(String columnName) {
        List<WebElement> headers = driver.findElements(By.xpath("//div[@role='columnheader']"));
        int columnIndex = -1;

        for (int i = 0; i < headers.size(); i++) {
            if (headers.get(i).getText().equalsIgnoreCase(columnName.trim())) {
                columnIndex = i + 1;
                break;
            }
        }

        if (columnIndex == -1) {
            throw new RuntimeException("Column '" + columnName + "' not found.");
        }

        List<WebElement> columnCells = driver.findElements(
                By.xpath("//div[@role='row']/div[" + columnIndex + "]")
        );

        return columnCells.stream()
                .map(WebElement::getText)
                .filter(text -> !text.trim().isEmpty())
                .skip(1)
                .collect(Collectors.toList());
    }
}
