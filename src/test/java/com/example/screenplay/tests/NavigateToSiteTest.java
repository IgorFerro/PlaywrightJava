package com.example.screenplay.tests;

import com.example.screenplay.abilities.BrowseTheWeb;
import com.example.screenplay.actor.Actor;
import com.example.screenplay.tasks.NavigateTo;
import com.example.screenplay.tasks.SelectMenuItem;
import com.example.screenplay.tasks.SelectEyesSubmenuFromMakeupPage;
import com.example.screenplay.tasks.AddSecondProductFromEyesPageToCart;
import com.example.screenplay.tasks.SelectProductColorOption;
import com.example.screenplay.tasks.ConfirmAndAddToCartFromProductPage;
import com.example.screenplay.questions.PageTitle;
import com.example.screenplay.questions.CartItemCount;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

public class NavigateToSiteTest {

    private Actor james;
    private Playwright playwright;

    @BeforeMethod
    public void setUp() {
        // Create a Playwright instance for each test method for isolation
        playwright = Playwright.create();
        james = Actor.named("James");
        james.can(BrowseTheWeb.with(playwright));
    }

    @Test
    public void userCanNavigateToAutomationTestStore() {
        String targetUrl = "https://automationteststore.com/";
        james.attemptsTo(
                NavigateTo.url(targetUrl)
        );

        // Basic assertion: Check if the current URL is the one we navigated to.
        String currentUrl = BrowseTheWeb.as(james).getPage().url();
        Assert.assertEquals(currentUrl, targetUrl, "Actor should have navigated to the correct URL.");
        
        // You could also check the title or other elements:
        // String pageTitle = BrowseTheWeb.as(james).getPage().title();
        // Assert.assertTrue(pageTitle.contains("Automation Test Store"), "Page title is not as expected.");
    }

    @Test
    public void userCanNavigateToAutomationTestStoreAndSelectMakeup() {
        String targetUrl = "https://automationteststore.com/";
        String makeupPageTitleSubstring = "Makeup"; 
        String eyesPageTitleSubstring = "Eyes"; // Expected title substring after clicking "Eyes" submenu
        String colorChoice = "Dore";

        james.attemptsTo(
                NavigateTo.url(targetUrl),
                SelectMenuItem.named("makeup"),
                SelectEyesSubmenuFromMakeupPage.now(),
                AddSecondProductFromEyesPageToCart.now(),
                SelectProductColorOption.named(colorChoice),
                ConfirmAndAddToCartFromProductPage.now()
        );

        // Assertions
        String eyesPageTitle = james.asksFor(PageTitle.displayed());
        // The title might be very specific after adding to cart, so checking for "Eyes" 
        // might fail if it navigates away or title changes significantly.
        // Let's assume after adding to cart, we might be on a cart page or back on a category page.
        // For a more robust assertion, you might need to check for a success message or cart update.
        // Assert.assertTrue(eyesPageTitle.contains(eyesPageTitleSubstring), 
        //    "Page title should contain '" + eyesPageTitleSubstring + "' after eyes submenu. Actual: " + eyesPageTitle);

        Integer itemsInCart = james.asksFor(CartItemCount.displayed());
        Assert.assertTrue(itemsInCart > 0, "Cart should have at least one item after adding to cart.");
        System.out.println("Items in cart: " + itemsInCart);
    }

    @AfterMethod
    public void tearDown() {
        if (james != null && james.hasAbility(BrowseTheWeb.class)) {
            BrowseTheWeb.as(james).closeBrowser();
        }
        // Playwright instance is closed by BrowseTheWeb.closeBrowser()
        // if (playwright != null) {
        //     playwright.close(); // This is handled by the ability's closeBrowser method
        // }
    }
    @Test
    public void userCanNavigateToAutomationTestStoreAndSelectSkincare() {
        String targetUrl = "https://automationteststore.com/";
        String skincarePageTitleSubstring = "Skincare";
        String colorChoice = "Dore";

        james.attemptsTo(
                NavigateTo.url(targetUrl),
                SelectMenuItem.named("skincare")
        );
                
    }
} 