package com.example.screenplay.tasks;

import com.example.screenplay.actor.Actor;
import com.example.screenplay.interactions.Click;
import com.example.screenplay.ui.ProductDetailsPageTargets;

public class ConfirmAndAddToCartFromProductPage implements Task {

    public static ConfirmAndAddToCartFromProductPage now() {
        return new ConfirmAndAddToCartFromProductPage();
    }

    @Override
    public void performAs(Actor actor) {
        actor.attemptsTo(
                Click.on(ProductDetailsPageTargets.ADD_TO_CART_BUTTON)
        );
    }
} 