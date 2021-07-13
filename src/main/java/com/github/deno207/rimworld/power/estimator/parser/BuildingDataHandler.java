package com.github.deno207.rimworld.power.estimator.parser;

import com.github.deno207.rimworld.power.estimator.data.Battery;
import com.github.deno207.rimworld.power.estimator.data.BuildingManager;
import com.github.deno207.rimworld.power.estimator.data.Consumer;
import com.github.deno207.rimworld.power.estimator.data.Generator;
import com.github.deno207.rimworld.power.estimator.data.TimePeriod;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class BuildingDataHandler extends DefaultHandler {

    private static final String GENERATOR_TAG = "generator";
    private static final String NAME_TAG = "name";
    private static final String POWER_GENERATED_TAG = "power-generated";
    private static final String GENERATION_PERIOD_TAG = "generation-period";
    private static final String CONSUMER_TAG = "consumer";
    private static final String POWER_DRAW_TAG = "power-draw";
    private static final String DRAW_PERIOD_TAG = "draw-period";
    private static final String BATTERY_TAG = "battery";
    private static final String CHARGE_TAG = "charge";
    private static final String EFFICIENCY_TAG = "efficiency";

    private Generator generator;
    private Consumer consumer;
    private Battery battery;
    private boolean generatorTag;
    private boolean consumerTag;
    private boolean batteryTag;
    private boolean nameTag;
    private boolean powerGeneratedTag;
    private boolean generationPeriodTag;
    private boolean powerDrawTag;
    private boolean drawPeriodTag;
    private boolean chargeTag;
    private boolean efficiencyTag;

    private final BuildingManager buildingManager;

    public BuildingDataHandler(BuildingManager buildingManager) {
        this.buildingManager = buildingManager;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        switch (qName) {
            case GENERATOR_TAG -> {
                generator = new Generator();
                generatorTag = true;
            }
            case CONSUMER_TAG -> {
                consumer = new Consumer();
                consumerTag = true;
            }
            case BATTERY_TAG -> {
                battery = new Battery();
                batteryTag = true;
            }
            case NAME_TAG -> nameTag = true;
            case POWER_GENERATED_TAG -> powerGeneratedTag = true;
            case GENERATION_PERIOD_TAG -> generationPeriodTag = true;
            case POWER_DRAW_TAG -> powerDrawTag = true;
            case DRAW_PERIOD_TAG -> drawPeriodTag = true;
            case CHARGE_TAG -> chargeTag = true;
            case EFFICIENCY_TAG -> efficiencyTag = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        switch (qName) {
            case GENERATOR_TAG -> {
                buildingManager.addGenerator(generator);
                generator = null;
                generatorTag = false;
            }
            case CONSUMER_TAG -> {
                buildingManager.addConsumer(consumer);
                consumer = null;
                consumerTag = false;
            }
            case BATTERY_TAG -> {
                buildingManager.addBattery(battery);
                battery = null;
                batteryTag = false;
            }
            case NAME_TAG -> nameTag = false;
            case POWER_GENERATED_TAG -> powerGeneratedTag = false;
            case GENERATION_PERIOD_TAG -> generationPeriodTag = false;
            case POWER_DRAW_TAG -> powerDrawTag = false;
            case DRAW_PERIOD_TAG -> drawPeriodTag = false;
            case CHARGE_TAG -> chargeTag = false;
            case EFFICIENCY_TAG -> efficiencyTag = false;
        }
    }

    @Override
    public void characters(char[] characters, int start, int length) {
        String value = String.valueOf(characters);

        if (nameTag && generatorTag) {
            generator.setName(value);
        } else if (nameTag && consumerTag) {
            consumer.setName(value);
        } else if (nameTag && batteryTag) {
            battery.setName(value);
        }
        if (powerGeneratedTag) {
            generator.setPowerGenerated(Integer.parseInt(value));
        }
        if (generationPeriodTag) {
            generator.setGeneratorPeriod(TimePeriod.valueOf(value));
        }
        if (powerDrawTag) {
            consumer.setPowerConsumed(Integer.parseInt(value));
        }
        if (drawPeriodTag) {
            consumer.setConsumptionPeriod(TimePeriod.valueOf(value));
        }
        if (chargeTag) {
            battery.setStorageCapacity(Integer.parseInt(value));
        }
        if (efficiencyTag) {
            battery.setEfficiency(Float.parseFloat(value));
        }
    }
}
