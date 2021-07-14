package com.github.deno207.rimworld.power.estimator.data;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Consumer consumer = (Consumer) o;
        return Objects.equals(name, consumer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "<consumer>\n<name>" + name + "</name>\n<power-draw>" + powerConsumed + "</power-draw>\n" +
                "<consumption-period>" + consumptionPeriod + "</consumption-period>\n</consumer>";
    }
}
