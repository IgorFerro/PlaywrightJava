package com.example.screenplay.tasks;

import com.example.screenplay.actor.Actor;
import com.example.screenplay.interactions.OpenUrl;

public class NavigateTo implements Task {

    private final String url;

    public NavigateTo(String url) {
        this.url = url;
    }

    public static NavigateTo url(String url) {
        return new NavigateTo(url);
    }

    @Override
    public void performAs(Actor actor) {
        actor.attemptsTo(OpenUrl.to(this.url));
        // In a more complex task, you might have multiple interactions or even other tasks.
        // For example: actor.attemptsTo(AcceptCookies.policy(), OpenUrl.to(this.url));
    }
} 