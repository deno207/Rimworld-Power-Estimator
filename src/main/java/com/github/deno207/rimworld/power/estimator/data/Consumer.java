package com.github.deno207.rimworld.power.estimator.data;

public class Consumer {

    private final String name;
    private final int powerConsumed;
    private final TimePeriod consumptionPeriod;

    public Consumer(String name, int powerConsumed, TimePeriod consumptionPeriod) {
        this.name = name;
        this.powerConsumed = powerConsumed;
        this.consumptionPeriod = consumptionPeriod;
    }

    public String getName() {
        return name;
    }

    public int getPowerConsumed() {
        return powerConsumed;
    }

    public TimePeriod getConsumptionPeriod() {
        return consumptionPeriod;
    }
}
