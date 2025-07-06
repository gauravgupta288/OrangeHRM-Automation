package com.orangehrm.framework.dataProviders;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {
    @DataProvider(name = "validCredentials")
    public static Object[][] validCredentials() {
        return new Object[][]{
                {"admin", "admin123"},
                {"hrmanager", "hr123"}
        };
    }

    @DataProvider(name = "invalidCredentials")
    public static Object[][] invalidCredentials() {
        return new Object[][]{
                {"wrongUser", "wrongPass"},
                {"admin", "wrongPass"},
                {"", ""},
                {"admin", ""}
        };
    }
}
