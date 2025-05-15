package com.example.screenplay.interactions;

import com.example.screenplay.abilities.BrowseTheWeb;
import com.example.screenplay.actor.Actor;
import com.microsoft.playwright.Page;

public class OpenUrl implements Interaction {

    private final String url;

    public OpenUrl(String url) {
        this.url = url;
    }

    public static OpenUrl to(String url) {
        return new OpenUrl(url);
    }

    @Override
    public void performAs(Actor actor) {
        Page page = BrowseTheWeb.as(actor).getPage();
        page.navigate(url);
        System.out.println(actor.getName() + " navigated to: " + url);
    }
} 