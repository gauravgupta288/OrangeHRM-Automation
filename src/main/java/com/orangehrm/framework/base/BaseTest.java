package com.orangehrm.framework.base;

import com.orangehrm.framework.factory.DriverFactory;
import com.orangehrm.framework.utils.ConfigReader;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.slf4j.MDC;
import org.testng.annotations.*;
import com.orangehrm.framework.utils.Log;
import org.slf4j.Logger;
import org.testng.annotations.*;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected Logger logger;

    @BeforeClass
    @Parameters({"env", "browser"})
    @Description("Driver loaded")
    public void setup(@Optional("stage") String env, @Optional("chrome") String browser) throws IOException {
        ConfigReader.loadConfig(env);
        MDC.put("thread", Thread.currentThread().getName()); // ensure MDC set
        logger = Log.getLogger(this.getClass());
        DriverFactory.initDriver(browser);
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(ConfigReader.get("base.url"));
    }

    @BeforeMethod()
    public void printCurrentPage() {
    }

    @AfterClass
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
