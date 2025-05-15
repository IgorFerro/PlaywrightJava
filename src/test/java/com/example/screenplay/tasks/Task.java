package com.example.screenplay.tasks;

import com.example.screenplay.actor.Actor;

@FunctionalInterface
public interface Task {
    void performAs(Actor actor);
} 