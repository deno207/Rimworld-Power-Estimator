package com.github.deno207.rimworld.power.estimator.data;

import java.util.Objects;

public class Battery {

    private String name;
    private int storageCapacity;
    private float efficiency;

    public String getName() {
        return name;
    }

    public int getStorageCapacity() {
        return storageCapacity;
    }

    public float getEfficiency() {
        return efficiency;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStorageCapacity(int storageCapacity) {
        this.storageCapacity = storageCapacity;
    }

    public void setEfficiency(float efficiency) {
        this.efficiency = efficiency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Battery battery = (Battery) o;
        return Objects.equals(name, battery.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
