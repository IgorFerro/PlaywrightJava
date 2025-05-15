package com.example.screenplay.tasks;

import com.example.screenplay.actor.Actor;
import com.example.screenplay.abilities.BrowseTheWeb;
import com.example.screenplay.interactions.Click;
import com.example.screenplay.ui.EyesCategoryPageTargets;

public class AddSecondProductFromEyesPageToCart implements Task {

    public static AddSecondProductFromEyesPageToCart now() {
        return new AddSecondProductFromEyesPageToCart();
    }

    @Override
    public void performAs(Actor actor) {
        BrowseTheWeb.as(actor).getPage().waitForTimeout(5000);
        actor.attemptsTo(
                Click.on(EyesCategoryPageTargets.WATERPROOF_CONCEALER_PRODUCT_LINK)
        );
    }
} 