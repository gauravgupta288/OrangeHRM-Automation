package com.orangehrm.tests.ui;

import com.orangehrm.framework.base.BaseTest;
import com.orangehrm.framework.dataProviders.LoginDataProvider;
import com.orangehrm.framework.pages.DashboardPage;
import com.orangehrm.framework.pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.testng.Tag;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.orangehrm.framework.listeners.TestListener.class)
public class InvalidLoginTest extends BaseTest {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    @Test(description = "Test to verify that user cannot log in with invalid credentials", dataProvider = "invalidCredentials", dataProviderClass = LoginDataProvider.class)
    @Tag("negative")
    @Description("Attempt login with invalid username/password and validate error message")
    public void verifyInvalidLogin(String username, String password) {
        System.out.println("Thread ID in testLogin: " + Thread.currentThread().getId());
        logger.info("*****************************************************************");
        logger.info("Starting invalid login test...");

        loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        String errorMessage = loginPage.getLoginErrorMessage(); // implement this in your LoginPage
        logger.info("Captured error message: " + errorMessage);

        Assert.assertTrue(errorMessage.contains("Invalid credentials") || !dashboardPage.isPageLoaded(),
                "Expected error message not displayed or dashboard should not load.");

        logger.info("Invalid login test completed.");
    }
}
