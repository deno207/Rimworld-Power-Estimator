package com.github.deno207.rimworld.power.estimator.data;

import java.util.ArrayList;

public class BuildingManager {

    private final ArrayList<Generator> generators;
    private final ArrayList<Battery> batteries;
    private final ArrayList<Consumer> consumers;

    public BuildingManager() {
        generators = new ArrayList<>();
        batteries = new ArrayList<>();
        consumers = new ArrayList<>();
    }

    public void addGenerator(Generator generator) {
        if (generators.contains(generator)) {
            throw new IllegalArgumentException("The generator with name " + generator.getName() + " already exists");
        }
        generators.add(generator);
    }

    public void addBattery(Battery battery) {
        if (batteries.contains(battery)) {
            throw new IllegalArgumentException("The battery with name " + battery.getName() + " already exists");
        }
        batteries.add(battery);
    }

    public void addConsumer(Consumer consumer) {
        if (consumers.contains(consumer)) {
            throw new IllegalArgumentException("The consumer with name " + consumer.getName() + " already exists");
        }
        consumers.add(consumer);
    }
}
