package com.example.pages;

import com.example.core.BasePage;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

/**
 * Minimal representation of the Playwright documentation landing page.
 */
public class DocumentationPage extends BasePage {

    private static final String TITLE_SELECTOR = "article h1";

    public DocumentationPage(Page page) {
        super(page);
    }

    public String getTitle() {
        page.waitForSelector(TITLE_SELECTOR, new Page.WaitForSelectorOptions()
                .setState(WaitForSelectorState.VISIBLE));
        return page.textContent(TITLE_SELECTOR);
    }
}
