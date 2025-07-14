package com.orangehrm.framework.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverManager implements DriverManager{
    @Override
    public WebDriver getDriver(boolean local) {
        return new EdgeDriver();
    }
}
