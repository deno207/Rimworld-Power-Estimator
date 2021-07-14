package com.github.deno207.rimworld.power.estimator.data;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Generator generator = (Generator) o;
        return Objects.equals(name, generator.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "<generator>\n<name>" + name + "</name>\n<power-generated>" + powerGenerated + "</power-generated>\n" +
                "<generation-period>" + generatorPeriod + "</generation-period>\n</generator>";
    }
}
