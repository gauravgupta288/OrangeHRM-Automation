package com.orangehrm.framework.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverManager implements DriverManager{
    @Override
    public WebDriver getDriver() {
        return new FirefoxDriver();
    }
}
