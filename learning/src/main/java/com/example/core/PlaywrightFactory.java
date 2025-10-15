package com.example.core;

import com.example.config.EnvironmentConfig;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

/**
 * Centralised factory that encapsulates Playwright lifecycle for tests.
 */
public class PlaywrightFactory {

    private final EnvironmentConfig config;
    private Playwright playwright;
    private Browser browser;
    private BrowserContext context;
    private Page page;

    public PlaywrightFactory(EnvironmentConfig config) {
        this.config = config;
    }

    public Page createPage() {
        playwright = Playwright.create();
        browser = launchBrowser();
        context = browser.newContext(new Browser.NewContextOptions()
                .setBaseURL(config.getBaseUrl()));
        page = context.newPage();
        page.setDefaultTimeout(config.getDefaultTimeout());
        return page;
    }

    private Browser launchBrowser() {
        BrowserType.LaunchOptions options = new BrowserType.LaunchOptions()
                .setHeadless(config.isHeadless());

        return switch (config.getBrowser().toLowerCase()) {
            case "firefox" -> playwright.firefox().launch(options);
            case "webkit" -> playwright.webkit().launch(options);
            case "chromium", "chrome" -> playwright.chromium().launch(options);
            default -> throw new IllegalArgumentException("Unsupported browser: " + config.getBrowser());
        };
    }

    public void close() {
        if (context != null) {
            context.close();
            context = null;
        }
        if (browser != null) {
            browser.close();
            browser = null;
        }
        if (playwright != null) {
            playwright.close();
            playwright = null;
        }
        page = null;
    }
}
