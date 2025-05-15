package com.example.screenplay.tasks;

import com.example.screenplay.actor.Actor;
// import com.example.screenplay.interactions.Click; // No longer used
import com.example.screenplay.interactions.Hover; // New import
import com.example.screenplay.ui.MainMenuTargets;

public class SelectMenuItem implements Task {
    private final String menuName;

    private SelectMenuItem(String menuName) {
        this.menuName = menuName;
    }

    public static SelectMenuItem now() {
        return new SelectMenuItem("makeup"); // Default to makeup menu
    }

    public static SelectMenuItem named(String menuName) {
        return new SelectMenuItem(menuName.toLowerCase());
    }

    @Override
    public void performAs(Actor actor) {
        switch (menuName) {
            case "makeup":
                actor.attemptsTo(Hover.over(MainMenuTargets.MAKEUP_MENU_ITEM));
                break;
            case "skincare":
                actor.attemptsTo(Hover.over(MainMenuTargets.SKINCARE_MENU_ITEM));
                break;
            default:
                throw new IllegalArgumentException("Unknown menu: " + menuName + ". Available menus: makeup, skincare");
        }
    }
} 