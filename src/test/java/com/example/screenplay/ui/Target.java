package com.example.screenplay.ui;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;

public class Target {

    private final String name;
    private final String selector;

    private Target(String name, String selector) {
        this.name = name;
        this.selector = selector;
    }

    public static Target called(String name) {
        // This is a builder-style approach, actual selector provided by a method like "locatedBy"
        return new Target(name, ""); // Placeholder selector
    }

    public Target locatedBy(String selector) {
        return new Target(this.name, selector);
    }

    public String getName() {
        return name;
    }

    public String getSelector() {
        return selector;
    }

    public Locator resolveFor(Page page) {
        return page.locator(this.selector);
    }
} 