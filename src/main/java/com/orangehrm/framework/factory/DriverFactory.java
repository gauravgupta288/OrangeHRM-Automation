package com.orangehrm.framework.factory;

import com.orangehrm.framework.drivers.ChromeDriverManager;
import com.orangehrm.framework.drivers.DriverManager;
import com.orangehrm.framework.drivers.EdgeDriverManager;
import com.orangehrm.framework.drivers.FirefoxDriverManager;
import com.orangehrm.framework.utils.ConfigReader;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public static DriverManager getDriverManager(String browser) {
        switch (browser.toLowerCase()){
            case "chrome":
            default:
                return new ChromeDriverManager();
            case "firefox":
                return new FirefoxDriverManager();
            case "edge":
                return new EdgeDriverManager();
        }
    }

    public static void initDriver(String browser){
        boolean isLocal = Boolean.parseBoolean(ConfigReader.get("localExecution"));
        DriverManager driverManager = getDriverManager(browser);
        driverThreadLocal.set(driverManager.getDriver(isLocal));
    }
    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    public static void quitDriver() {
        driverThreadLocal.get().quit();
        driverThreadLocal.remove();
    }
}

