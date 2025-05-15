package com.example.screenplay.ui;

public class MainMenuTargets {
    public static final Target MAKEUP_MENU_ITEM = Target.called("Makeup Menu Item")
            .locatedBy("(//a[contains(text(),'Makeup')])[2]");

    public static final Target SKINCARE_MENU_ITEM = Target.called("Makeup Menu Item")
            .locatedBy("(//a[contains(text(),'Skincare')])[3]");
} 