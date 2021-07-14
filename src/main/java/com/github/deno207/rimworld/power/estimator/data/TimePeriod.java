package com.github.deno207.rimworld.power.estimator.data;

public enum TimePeriod {
    ALWAYS(1.0f), DAY_TIME(0.5f);

    private final float timeModifier;

    TimePeriod(float timeModifier) {
        this.timeModifier = timeModifier;
    }

    public float getTimeModifier() {
        return timeModifier;
    }

}
