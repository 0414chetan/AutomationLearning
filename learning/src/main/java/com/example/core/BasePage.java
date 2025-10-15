package com.example.core;

import com.microsoft.playwright.Page;

/**
 * Parent class for all page objects with helper assertions and interactions.
 */
public abstract class BasePage {

    protected final Page page;

    protected BasePage(Page page) {
        this.page = page;
    }

    public String getPageTitle() {
        return page.title();
    }
}
