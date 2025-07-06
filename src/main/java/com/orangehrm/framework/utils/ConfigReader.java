package com.orangehrm.framework.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    public static void loadConfig(String env) {
        properties = new Properties();
        String fileName = "config/" + env + ".properties";
        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream(fileName)) {
            if (input == null) {
                throw new RuntimeException("Config file not found in classpath: " + fileName);
            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config: " + fileName, e);
        }
    }


    public static String get(String key) {
        return properties.getProperty(key);
    }
}
