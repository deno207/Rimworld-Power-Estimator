package com.github.deno207.rimworld.power.estimator.data;

public class Generator {

    private final String name;
    private final int powerGenerated;
    private final TimePeriod generatorPeriod;

     public Generator(String name, int powerGenerated, TimePeriod generatorPeriod) {
         this.name = name;
         this.powerGenerated = powerGenerated;
         this.generatorPeriod = generatorPeriod;
     }

    public String getName() {
        return name;
    }

    public int getPowerGenerated() {
        return powerGenerated;
    }

    public TimePeriod getGeneratorPeriod() {
        return generatorPeriod;
    }
}
