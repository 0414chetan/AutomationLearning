package com.example.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

/**
 * Loads the environment configuration from the classpath and exposes type-safe accessors.
 */
public final class EnvironmentConfig {

    private static final String DEFAULT_CONFIG_FILE = "config/config.properties";

    private static EnvironmentConfig instance;

    private final Properties properties = new Properties();

    private EnvironmentConfig() {
        load(DEFAULT_CONFIG_FILE);
    }

    public static EnvironmentConfig getInstance() {
        if (instance == null) {
            instance = new EnvironmentConfig();
        }
        return instance;
    }

    public void load(String resourcePath) {
        try (InputStream input = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream(resourcePath)) {
            if (Objects.isNull(input)) {
                throw new IllegalStateException("Unable to find configuration file: " + resourcePath);
            }
            properties.load(input);
        } catch (IOException ex) {
            throw new IllegalStateException("Unable to load configuration file: " + resourcePath, ex);
        }
    }

    public String getBaseUrl() {
        return properties.getProperty("base.url", "https://playwright.dev/java/");
    }

    public String getBrowser() {
        return properties.getProperty("browser", "chromium");
    }

    public boolean isHeadless() {
        return Boolean.parseBoolean(properties.getProperty("headless", "true"));
    }

    public int getDefaultTimeout() {
        return Integer.parseInt(properties.getProperty("timeout.ms", "30000"));
    }
}
