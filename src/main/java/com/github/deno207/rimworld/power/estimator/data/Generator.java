package com.github.deno207.rimworld.power.estimator.data;

public class Generator {

    private String name;
    private int powerGenerated;
    private TimePeriod generatorPeriod;

    public String getName() {
        return name;
    }

    public int getPowerGenerated() {
        return powerGenerated;
    }

    public TimePeriod getGeneratorPeriod() {
        return generatorPeriod;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPowerGenerated(int powerGenerated) {
        this.powerGenerated = powerGenerated;
    }

    public void setGeneratorPeriod(TimePeriod generatorPeriod) {
        this.generatorPeriod = generatorPeriod;
    }
}
