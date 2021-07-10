package com.github.deno207.rimworld.power.estimator.data;

import java.util.ArrayList;

public class BuildingManager {

    private ArrayList<Generator> generators;
    private ArrayList<Battery> batteries;
    private ArrayList<Consumer> consumers;

    public BuildingManager() {
        generators = new ArrayList<>();
        batteries = new ArrayList<>();
        consumers = new ArrayList<>();
    }


}
