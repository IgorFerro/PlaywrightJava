package com.example.screenplay.ui;

public class MakeupPageTargets {
    // User provided new specific XPath for the Eyes submenu under Makeup
    public static final Target EYES_SUBMENU = Target.called("Eyes Submenu (under Makeup)")
            .locatedBy("//*[@id=\"categorymenu\"]/nav/ul/li[3]/div/ul[1]/li[2]/a");

            
} 