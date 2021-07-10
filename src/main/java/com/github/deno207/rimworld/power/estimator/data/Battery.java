package com.github.deno207.rimworld.power.estimator.data;

public class Battery {

    private final String name;
    private final int storageCapacity;
    private final float efficiency;

    public Battery(String name, int storageCapacity, float efficiency) {
        this.name = name;
        this.storageCapacity = storageCapacity;
        this.efficiency = efficiency;
    }

    public String getName() {
        return name;
    }

    public int getStorageCapacity() {
        return storageCapacity;
    }

    public float getEfficiency() {
        return efficiency;
    }
}
