package com.example.screenplay.ui;

public class ProductDetailsPageTargets {
    // User provided XPath for dropdown: //select[@id='option319']
    public static final Target COLOR_DROPDOWN = Target.called("Color Dropdown")
            .locatedBy("//select[@id='option319']");

    // User provided linkText for Add to Cart: Add to Cart
    public static final Target ADD_TO_CART_BUTTON = Target.called("Add to Cart Button")
            .locatedBy("//a[normalize-space()='Add to Cart']"); // Using XPath for link text for consistency with Playwright locators
} 