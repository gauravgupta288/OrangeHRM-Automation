//package com.orangehrm.framework.listeners;
//
//import org.testng.ITestResult;
//import org.testng.TestListenerAdapter;
//
//public class PageHeaderListener extends TestListenerAdapter {
//
//    @Override
//    public void onTestStart(ITestResult result) {
//        Object testInstance = result.getInstance();
//        if (testInstance instanceof PageAware) {
//            String header = ((PageAware) testInstance).getCurrentPageHeader();
//            System.out.println(">>> Current Page: " + header);
//        }
//    }
////}
//
