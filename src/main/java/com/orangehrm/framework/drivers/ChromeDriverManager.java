package com.orangehrm.framework.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeDriverManager implements DriverManager{
    @Override
    public WebDriver getDriver(boolean local) {

        if(local){
            return new ChromeDriver();
        }else{
            try {
                ChromeOptions options = new ChromeOptions();
                return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
            } catch (MalformedURLException e) {
                throw new RuntimeException("Invalid Selenium Grid URL", e);
            }
        }

    }
}
