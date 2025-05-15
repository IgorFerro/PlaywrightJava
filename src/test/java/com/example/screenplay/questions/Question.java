package com.example.screenplay.questions;

import com.example.screenplay.actor.Actor;

@FunctionalInterface
public interface Question<T> {
    T answeredBy(Actor actor);
} 