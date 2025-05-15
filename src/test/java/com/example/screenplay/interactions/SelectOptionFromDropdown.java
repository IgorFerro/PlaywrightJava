package com.example.screenplay.interactions;

import com.example.screenplay.abilities.BrowseTheWeb;
import com.example.screenplay.actor.Actor;
import com.example.screenplay.ui.Target;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;

public class SelectOptionFromDropdown implements Interaction {

    private final Target dropdownTarget;
    private final String optionText;

    private SelectOptionFromDropdown(Target dropdownTarget, String optionText) {
        this.dropdownTarget = dropdownTarget;
        this.optionText = optionText;
    }

    public static SelectOptionFromDropdown text(String optionText) {
        // Builder style: .from(Target target) will complete it
        return new SelectOptionFromDropdown(null, optionText);
    }

    public SelectOptionFromDropdown from(Target dropdownTarget) {
        return new SelectOptionFromDropdown(dropdownTarget, this.optionText);
    }

    @Override
    public void performAs(Actor actor) {
        Page page = BrowseTheWeb.as(actor).getPage();
        System.out.println(actor.getName() + " selects option '" + optionText + "' from " + dropdownTarget.getName());
        // First click the dropdown to open it - this might be necessary for some custom dropdowns, but not always for native <select>
        // dropdownTarget.resolveFor(page).click(); // Potentially remove if direct selection works
        dropdownTarget.resolveFor(page).selectOption(new SelectOption().setLabel(optionText));
    }
} 