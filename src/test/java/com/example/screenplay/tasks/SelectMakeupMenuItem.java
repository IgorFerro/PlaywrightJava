package com.example.screenplay.tasks;

import com.example.screenplay.actor.Actor;
// import com.example.screenplay.interactions.Click; // No longer used
import com.example.screenplay.interactions.Hover; // New import
import com.example.screenplay.ui.MainMenuTargets;

public class SelectMakeupMenuItem implements Task {

    public static SelectMakeupMenuItem now() {
        return new SelectMakeupMenuItem();
    }

    @Override
    public void performAs(Actor actor) {
        actor.attemptsTo(
                // Click.on(MainMenuTargets.MAKEUP_MENU_ITEM) // Old interaction
                Hover.over(MainMenuTargets.MAKEUP_MENU_ITEM) // New interaction
        );
    }
} 