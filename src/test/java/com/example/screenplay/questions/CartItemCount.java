package com.example.screenplay.questions;

import com.example.screenplay.abilities.BrowseTheWeb;
import com.example.screenplay.actor.Actor;
import com.microsoft.playwright.Page;

public class CartItemCount implements Question<Integer> {

    // Example selector for cart item count - this will LIKELY NEED ADJUSTMENT
    // based on the actual website's HTML structure for the cart count display.
    private static final String CART_COUNT_SELECTOR = ".cart_total"; // e.g., a span with class 'cart-count'

    private CartItemCount() {}

    public static Question<Integer> displayed() {
        return new CartItemCount();
    }

    @Override
    public Integer answeredBy(Actor actor) {
        Page page = BrowseTheWeb.as(actor).getPage();
        String countText = page.textContent(CART_COUNT_SELECTOR);
        try {
            // Assuming the text is just a number. If it's like "1 item(s)", parsing is needed.
            // Example: "Items: 1" -> parse out "1"
            // For now, simple parsing for a number, or 0 if not found/parsable.
            if (countText != null && !countText.isEmpty()) {
                // Extracting number part, e.g. from "1 Item(s) - $10.00"
                java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("\\d+");
                java.util.regex.Matcher matcher = pattern.matcher(countText);
                if (matcher.find()) {
                    return Integer.parseInt(matcher.group(0));
                }
            }
        } catch (NumberFormatException e) {
            System.err.println("Could not parse cart count text: " + countText + " Error: " + e.getMessage());
            return 0; // Or throw an error
        }
        return 0; // Default if selector not found or text not parsable
    }
} 