package com.orangehrm.tests.ui;

import com.orangehrm.framework.base.BaseTest;
import com.orangehrm.framework.pages.AdminPage;
import com.orangehrm.framework.pages.DashboardPage;
import com.orangehrm.framework.pages.LoginPage;
import com.orangehrm.framework.utils.ConfigReader;
import io.qameta.allure.Description;
import io.qameta.allure.testng.Tag;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminTest extends BaseTest {
    private LoginPage loginPage;
    private AdminPage adminPage;

    @Test(description = "Test to verify that Admin table sorting is working")
    @Tag("smoke")
    @Description("Test to verify that Admin table sorting is working")
    public void verifyTableSortingInAscendingOrder() {
        System.out.println("Thread ID in testLogin: " + Thread.currentThread().getId());

        String username = ConfigReader.get("username");
        String password = ConfigReader.get("password");
        logger.info("*****************************************************************");
        logger.info("Starting login test...");

        loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        adminPage = new AdminPage(driver);


    }
}
