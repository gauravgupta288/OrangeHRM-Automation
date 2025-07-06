package com.orangehrm.tests.ui;

import com.orangehrm.framework.base.BaseTest;
import com.orangehrm.framework.pages.DashboardPage;
import com.orangehrm.framework.pages.LoginPage;
import com.orangehrm.framework.utils.ConfigReader;
import io.qameta.allure.Description;
import io.qameta.allure.testng.AllureTestNg;
import io.qameta.allure.testng.Tag;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({AllureTestNg.class})
public class LoginTest extends BaseTest {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    @Test(description = "Test to verify that user can log in successfully and see dashboard")
    @Tag("smoke")
    @Description("Test to verify that user can log in successfully and see dashboard")
    public void verifySuccessfulLogin() {
        System.out.println("Thread ID in testLogin: " + Thread.currentThread().getId());

        String username = ConfigReader.get("username");
        String password = ConfigReader.get("password");
        logger.info("*****************************************************************");
        logger.info("Starting login test...");

        loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        dashboardPage = new DashboardPage(driver);
        dashboardPage.waitForPageLoad();
        logger.info("Test Ends");

        System.out.println("Page header : " + dashboardPage.getPageHeader());
        Assert.assertTrue(dashboardPage.isPageLoaded(), "Dashboard page not loaded within time");
        logger.info("Validation completed");
    }


}

