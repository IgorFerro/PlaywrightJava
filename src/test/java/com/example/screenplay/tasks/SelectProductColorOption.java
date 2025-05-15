package com.example.screenplay.tasks;

import com.example.screenplay.actor.Actor;
import com.example.screenplay.abilities.BrowseTheWeb;
import com.example.screenplay.interactions.SelectOptionFromDropdown;
import com.example.screenplay.ui.ProductDetailsPageTargets;

public class SelectProductColorOption implements Task {

    private final String color;

    public SelectProductColorOption(String color) {
        this.color = color;
    }

    public static SelectProductColorOption named(String color) {
        return new SelectProductColorOption(color);
    }

    @Override
    public void performAs(Actor actor) {
        BrowseTheWeb.as(actor).getPage().waitForTimeout(5000);

        actor.attemptsTo(
                SelectOptionFromDropdown.text(color).from(ProductDetailsPageTargets.COLOR_DROPDOWN)
        );
    }
} 