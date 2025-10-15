package com.example.tests;

import com.example.pages.DocumentationPage;
import com.example.pages.LandingPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LandingPageTest extends BaseTest {

    @Test(description = "Validate Playwright Java docs can be opened from the landing page")
    public void shouldNavigateToJavaDocs() {
        LandingPage landingPage = new LandingPage(page);
        Assert.assertTrue(landingPage.getPageTitle().contains("Playwright"),
                "Landing page title should contain Playwright");

        landingPage.openDocumentation();

        DocumentationPage docs = new DocumentationPage(page);
        Assert.assertTrue(docs.getTitle().toLowerCase().contains("playwright"),
                "Documentation page title should mention Playwright");
    }
}
