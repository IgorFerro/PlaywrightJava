package com.example.screenplay.ui;

public class EyesCategoryPageTargets {
    // Target for the add-to-cart icon of a product (previously referred to as the second product)
   // public static final Target PRODUCT_ADD_TO_CART_ICON = Target.called("Product Add to Cart Icon")
      //      .locatedBy(".col-md-3:nth-child(2) .fa-shopping-cart"); // Restoring the original selector for a specific product's cart icon
            // If the above doesn't work, you might need: .locatedBy(".col-md-3:nth-child(2) .fa");

    // New target for the Waterproof Protective Undereye Concealer text/link
    // Using a specific XPath selector to avoid strict mode validation issues
    public static final Target WATERPROOF_CONCEALER_PRODUCT_LINK = Target.called("Waterproof Protective Undereye Concealer Link")
            .locatedBy("//a[@class='prdocutname' and text()='Waterproof Protective Undereye Concealer' and @href='https://automationteststore.com/index.php?rt=product/product&path=36_39&product_id=56']");        
            
} 