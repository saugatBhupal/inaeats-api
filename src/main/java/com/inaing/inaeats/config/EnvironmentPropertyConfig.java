package com.inaing.inaeats.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class EnvironmentPropertyConfig {

    private static final Properties properties = new Properties();

    static {
        try (InputStream input = EnvironmentPropertyConfig.class.getClassLoader()
                .getResourceAsStream("application.properties")) {
            if (input == null) {
                throw new RuntimeException("Unable to find application.properties");
            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load application.properties", e);
        }
    }

    public static Properties getProperties() {
        return properties;
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
