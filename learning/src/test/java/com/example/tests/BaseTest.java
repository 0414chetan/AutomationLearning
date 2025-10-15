package com.example.tests;

import com.example.config.EnvironmentConfig;
import com.example.core.PlaywrightFactory;
import com.microsoft.playwright.Page;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class BaseTest {

    protected EnvironmentConfig config;
    protected PlaywrightFactory factory;
    protected Page page;

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        config = EnvironmentConfig.getInstance();
        factory = new PlaywrightFactory(config);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        page = factory.createPage();
        page.navigate(config.getBaseUrl());
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result) {
        if (!result.isSuccess()) {
            Path screenshotsDir = Paths.get("target/screenshots");
            try {
                Files.createDirectories(screenshotsDir);
                page.screenshot(new Page.ScreenshotOptions()
                        .setPath(screenshotsDir.resolve(result.getName() + ".png"))
                        .setFullPage(true));
            } catch (Exception ex) {
                System.err.println("Unable to capture screenshot: " + ex.getMessage());
            }
        }
        factory.close();
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        factory.close();
    }
}
