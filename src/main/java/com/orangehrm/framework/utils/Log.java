package com.orangehrm.framework.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

public class Log {
    public static Logger getLogger(Class<?> clazz) {
        // Set thread name or test class name as part of log file name
        MDC.put("threadId", Thread.currentThread().getName());
        return LoggerFactory.getLogger(clazz);
    }
}
