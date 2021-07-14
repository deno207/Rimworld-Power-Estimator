package com.github.deno207.rimworld.power.estimator.application;

import com.github.deno207.rimworld.power.estimator.data.BuildingManager;
import com.github.deno207.rimworld.power.estimator.parser.DataReader;

public class Application {

    private final BuildingManager buildingManager;

    public Application() {
        buildingManager = new BuildingManager();
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.run();
    }

    public void run() {
        DataReader reader = new DataReader(buildingManager);
        reader.readData();

        System.out.println(buildingManager);
    }
}
