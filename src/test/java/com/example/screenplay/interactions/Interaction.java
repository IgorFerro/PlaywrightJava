package com.example.screenplay.interactions;

import com.example.screenplay.actor.Actor;
import com.example.screenplay.tasks.Task;

@FunctionalInterface
public interface Interaction extends Task {
    void performAs(Actor actor);
} 