package com.example.pages;

import com.example.core.BasePage;
import com.microsoft.playwright.Page;

/**
 * Simple page object that models the Playwright Java landing page.
 */
public class LandingPage extends BasePage {

    private static final String GET_STARTED_LINK = "text=Get started";
    private static final String HERO_TITLE = "h1";

    public LandingPage(Page page) {
        super(page);
    }

    public void openDocumentation() {
        page.click(GET_STARTED_LINK);
        page.waitForURL("**/docs/intro");
    }

    public String getHeroTitle() {
        return page.textContent(HERO_TITLE);
    }
}
