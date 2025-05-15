package com.example.screenplay.abilities;

import com.microsoft.playwright.*;
import com.example.screenplay.actor.Actor;
import com.microsoft.playwright.options.LoadState;

public class BrowseTheWeb implements Ability {

    private final Page page;
    private final Playwright playwright;
    private final Browser browser;

    private BrowseTheWeb(Page page, Browser browser, Playwright playwright) {
        this.page = page;
        this.browser = browser;
        this.playwright = playwright;
    }

    public static BrowseTheWeb with(Playwright playwright) {
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions()
                .setHeadless(false) // You can make headless configurable
                .setArgs(java.util.Arrays.asList(
                    "--start-maximized",
                    "--disable-web-security",
                    "--disable-features=IsolateOrigins,site-per-process",
                    "--no-sandbox",
                    "--disable-setuid-sandbox"
                ));

        Browser browser = playwright.chromium().launch(launchOptions);
        
        // For a maximized window, viewport sizing might not be strictly necessary, 
        // but can be set if specific dimensions are desired after maximization attempts.
        // However, --start-maximized should handle it for most chromium browsers.
        BrowserContext context = browser.newContext(new Browser.NewContextOptions()
                .setViewportSize(null) // Using null viewport with --start-maximized
                .setIgnoreHTTPSErrors(true) // Ignore HTTPS errors
                .setJavaScriptEnabled(true) // Ensure JavaScript is enabled
                .setBypassCSP(true) // Bypass Content Security Policy
                .setAcceptDownloads(true)); // Accept downloads if needed
        
        Page page = context.newPage();
        page.setDefaultTimeout(60000); // Increase timeout to 60 seconds
        page.setDefaultNavigationTimeout(60000); // Increase navigation timeout to 60 seconds
        
        // Configure page to be more lenient with element selection
        page.setDefaultTimeout(60000);
        page.setDefaultNavigationTimeout(60000);
        
        // Add a global wait for stability
        page.waitForLoadState(LoadState.NETWORKIDLE, new Page.WaitForLoadStateOptions().setTimeout(60000));
        
        return new BrowseTheWeb(page, browser, playwright);
    }

    public static BrowseTheWeb as(Actor actor) {
        // This is a common way to retrieve an ability from an actor.
        // It requires the Actor class to have a way to store and retrieve abilities.
        if (!actor.hasAbility(BrowseTheWeb.class)) {
            throw new IllegalStateException(actor.getName() + " does not have the ability to browse the web.");
        }
        return actor.getAbility(BrowseTheWeb.class);
    }

    public Page getPage() {
        return page;
    }

    public void closeBrowser() {
        if (page != null && !page.isClosed()) {
            page.close();
        }
        if (browser != null && browser.isConnected()) {
            browser.close();
        }
        if (playwright != null) {
            playwright.close();
        }
    }
} 