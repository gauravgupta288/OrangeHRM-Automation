package com.orangehrm.framework.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class FirefoxDriverManager implements DriverManager{
    @Override
    public WebDriver getDriver(boolean local) {
        if(local){
            return new FirefoxDriver();
        }else{
            try {
                FirefoxOptions options = new FirefoxOptions();
                return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
            } catch (MalformedURLException e) {
                throw new RuntimeException("Invalid Selenium Grid URL", e);
            }
        }
    }
}
