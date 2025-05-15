package com.example.screenplay.actor;

import com.example.screenplay.abilities.Ability;
import com.example.screenplay.tasks.Task;
import com.example.screenplay.questions.Question;

import java.util.HashMap;
import java.util.Map;

public class Actor {
    private final String name;
    private final Map<Class<? extends Ability>, Ability> abilities;

    public Actor(String name) {
        this.name = name;
        this.abilities = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public static Actor named(String name) {
        return new Actor(name);
    }

    public Actor can(Ability ability) {
        this.abilities.put(ability.getClass(), ability);
        return this;
    }

    public <T extends Ability> T getAbility(Class<T> abilityClass) {
        if (!abilities.containsKey(abilityClass)) {
            throw new IllegalStateException(String.format("%s does not have the ability %s", name, abilityClass.getSimpleName()));
        }
        return abilityClass.cast(abilities.get(abilityClass));
    }

    public <T extends Ability> boolean hasAbility(Class<T> abilityClass) {
        return abilities.containsKey(abilityClass);
    }

    public void attemptsTo(Task... tasks) {
        for (Task task : tasks) {
            task.performAs(this);
        }
    }

    public <T> T asksFor(Question<T> question) {
        return question.answeredBy(this);
    }

    // If you want to use questions for assertions, you might add a method like:
    // public <T> void should(See<T> see) { See.seeThat(...); }
    // Or directly use TestNG assertions within the test method after tasks are performed.
} 