package com.example.screenplay.interactions;

import com.example.screenplay.abilities.BrowseTheWeb;
import com.example.screenplay.actor.Actor;
import com.example.screenplay.ui.Target;
import com.microsoft.playwright.Page;

public class Hover implements Interaction {

    private final Target target;

    private Hover(Target target) {
        this.target = target;
    }

    public static Hover over(Target target) {
        return new Hover(target);
    }

    @Override
    public void performAs(Actor actor) {
        Page page = BrowseTheWeb.as(actor).getPage();
        System.out.println(actor.getName() + " hovers over " + target.getName() + " located by " + target.getSelector());
        target.resolveFor(page).hover();
    }
} 