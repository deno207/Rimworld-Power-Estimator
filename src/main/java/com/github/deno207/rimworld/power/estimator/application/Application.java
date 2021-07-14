package com.github.deno207.rimworld.power.estimator.application;

import com.github.deno207.rimworld.power.estimator.data.BuildingManager;
import com.github.deno207.rimworld.power.estimator.parser.BuildingDataHandler;
import com.github.deno207.rimworld.power.estimator.parser.DataReader;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;

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
