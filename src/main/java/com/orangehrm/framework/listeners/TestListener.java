package com.orangehrm.framework.listeners;

import com.orangehrm.framework.utils.ScreenshotUtils;
import io.qameta.allure.Attachment;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        saveScreenshotToAllure();
    }
    @Attachment(value = "Failure Screenshot", type = "image/png")
    public byte[] saveScreenshotToAllure() {
        return ScreenshotUtils.takeScreenshot();
    }
}
