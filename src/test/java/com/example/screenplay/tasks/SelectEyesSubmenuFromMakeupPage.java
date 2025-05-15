package com.example.screenplay.tasks;

import com.example.screenplay.abilities.BrowseTheWeb;
import com.example.screenplay.actor.Actor;
import com.example.screenplay.interactions.Click;
import com.example.screenplay.ui.MakeupPageTargets;
import com.microsoft.playwright.Page;

public class SelectEyesSubmenuFromMakeupPage implements Task {

    public static SelectEyesSubmenuFromMakeupPage now() {
        return new SelectEyesSubmenuFromMakeupPage();
    }

    @Override
    public void performAs(Actor actor) {
        Page page = BrowseTheWeb.as(actor).getPage();
        
        System.out.println(actor.getName() + " waits for 5 seconds before attempting to click " + 
                           MakeupPageTargets.EYES_SUBMENU.getName() + ".");
        
        // WARNING: Using fixed timeouts (hard sleeps) is generally discouraged in test automation.
        // It can make tests slower and less reliable. Prefer conditional waits (e.g., for element visibility)
        // whenever possible. This is added based on a specific request for a fixed pause.
        page.waitForTimeout(5000); // 5000 milliseconds = 5 seconds

        actor.attemptsTo(
                Click.on(MakeupPageTargets.EYES_SUBMENU)
        );
    }
} 