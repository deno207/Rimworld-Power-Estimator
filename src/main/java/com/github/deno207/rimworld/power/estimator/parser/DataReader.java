package com.github.deno207.rimworld.power.estimator.parser;

import com.github.deno207.rimworld.power.estimator.data.BuildingManager;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

public class DataReader {

    private static final String CORE_BUILDING_RESOURCE = "/XML/core-data.xml";
    private static final String CUSTOM_BUILDING_FILE = "custom-building-data.xml";

    private final BuildingManager buildingManager;
    private final File customBuildingDataFile;

    public DataReader(BuildingManager buildingManager) {
        this.buildingManager = buildingManager;
        customBuildingDataFile = new File(CUSTOM_BUILDING_FILE);
    }

    public void readData() {
        InputStream coreDataStream = getClass().getResourceAsStream(CORE_BUILDING_RESOURCE);
        readBuildingData(coreDataStream);

        if (customBuildingDataFile.exists()) {
            readBuildingData(customBuildingDataFile);
        } else {
            createCustomBuildingFile();
        }
    }

    private void readBuildingData(InputStream buildingData) {
        try {
            SAXParserFactory parserFactory = SAXParserFactory.newInstance();
            SAXParser parser = parserFactory.newSAXParser();
            BuildingDataHandler dataHandler = new BuildingDataHandler(buildingManager);
            parser.parse(buildingData, dataHandler);
        } catch (IOException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }

    private void readBuildingData(File buildingDataFile) {
        try {
            FileInputStream fileStream = new FileInputStream(buildingDataFile);
            readBuildingData(fileStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createCustomBuildingFile() {
        try {
            if (customBuildingDataFile.createNewFile()) {
                FileWriter fileWriter = new FileWriter(customBuildingDataFile);
                fileWriter.write("<?xml version = \"1.0\"?>\n" +
                        "<building-data\n" +
                        "        xmlns=\"com.github.deno207\"\n" +
                        "        xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
                        "        xsi:schemaLocation=\"com.github.deno207 building-data.xsd\">\n" +
                        "</building-data>\n");
                fileWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
