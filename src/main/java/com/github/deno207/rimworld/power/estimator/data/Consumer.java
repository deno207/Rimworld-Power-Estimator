package com.github.deno207.rimworld.power.estimator.data;

public class Consumer {

    private String name;
    private int powerConsumed;
    private TimePeriod consumptionPeriod;

    public String getName() {
        return name;
    }

    public int getPowerConsumed() {
        return powerConsumed;
    }

    public TimePeriod getConsumptionPeriod() {
        return consumptionPeriod;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPowerConsumed(int powerConsumed) {
        this.powerConsumed = powerConsumed;
    }

    public void setConsumptionPeriod(TimePeriod consumptionPeriod) {
        this.consumptionPeriod = consumptionPeriod;
    }
}
