package com.example.screenplay.questions;

import com.example.screenplay.abilities.BrowseTheWeb;
import com.example.screenplay.actor.Actor;

public class PageTitle implements Question<String> {

    private PageTitle() { // Private constructor for utility-style class
    }

    public static Question<String> displayed() {
        return new PageTitle();
    }

    @Override
    public String answeredBy(Actor actor) {
        return BrowseTheWeb.as(actor).getPage().title();
    }
} 