package com.example.screenplay.interactions;

import com.example.screenplay.abilities.BrowseTheWeb;
import com.example.screenplay.actor.Actor;
import com.example.screenplay.ui.Target;
import com.microsoft.playwright.Page;

public class Click implements Interaction {

    private final Target target;

    private Click(Target target) {
        this.target = target;
    }

    public static Click on(Target target) {
        return new Click(target);
    }

    @Override
    public void performAs(Actor actor) {
        Page page = BrowseTheWeb.as(actor).getPage();
        System.out.println(actor.getName() + " clicks on " + target.getName() + " located by " + target.getSelector());
        target.resolveFor(page).click();
    }
} 