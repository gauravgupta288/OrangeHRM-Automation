package com.orangehrm.tests.ui;

import com.google.common.collect.Ordering;
import com.orangehrm.framework.base.BaseTest;
import com.orangehrm.framework.pages.AdminPage;
import com.orangehrm.framework.pages.LoginPage;
import com.orangehrm.framework.utils.ConfigReader;
import io.qameta.allure.Description;
import io.qameta.allure.testng.Tag;
import static org.testng.Assert.*;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class AdminTest extends BaseTest {
    private LoginPage loginPage;
    private AdminPage adminPage;
    @BeforeTest
    @Description("Login to app")
    public void loginToApp(){
        String username = ConfigReader.get("username");
        String password = ConfigReader.get("password");
        logger.info("*****************************************************************");
        logger.info("Starting login test...");

        loginPage = new LoginPage(driver);
        loginPage.login(username, password);
    }

    @Test(description = "Test to verify that Admin table sorting is working")
    @Tag("smoke")
    @Description("Test to verify that Admin table sorting is working")
    public void verifyTableSortingInAscendingOrder() {
        System.out.println("Thread ID in testLogin: " + Thread.currentThread().getId());

        adminPage = new AdminPage(driver);
        adminPage.clickOnAdminSidebar();
        adminPage.waitForPageLoad();
        assertTrue(adminPage.isPageLoaded());

        adminPage.sortColumn("Employee Name", true);
        List<String> employees = adminPage.getTableData("Employee Name");

        List<String> empLowerCase = employees.
                                    stream().
                                    map(emp -> emp.toLowerCase())
                                            .collect(Collectors.toList());


        assertTrue(Ordering.natural().isOrdered(empLowerCase));
    }

    @Test(description = "Test to verify that Admin table sorting is working")
    @Tag("smoke")
    @Description("Test to verify that Admin table sorting is working")
    public void verifyTableSortingInDescendingOrder() {
        System.out.println("Thread ID in testLogin: " + Thread.currentThread().getId());

        adminPage.sortColumn("Employee Name", false);
        List<String> employees = adminPage.getTableData("Employee Name");

        List<String> empLowerCase = employees.
                stream().
                map(emp -> emp.toLowerCase())
                .collect(Collectors.toList());


        assertTrue(Ordering.natural().reverse().isOrdered(empLowerCase));
    }
}
