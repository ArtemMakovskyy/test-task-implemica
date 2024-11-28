package org.example.сity.transportation.network;

import java.util.ArrayList;
import java.util.List;

/**
 * The CityRepository class follows the Singleton pattern and is responsible for managing
 * a centralized list of cities and their transportation network data. It provides
 * access to the list of cities and ensures that only one instance of the repository exists
 * throughout the application. This class loads and stores default city data in memory.
 */
public final class CityRepository {
    private static CityRepository instance;
    private final List<City> dataBase;

    private CityRepository() {
        this.dataBase = loadDefaultData();
    }

    public static synchronized CityRepository getInstance() {
        if (instance == null) {
            instance = new CityRepository();
        }
        return instance;
    }

    public List<City> getAllCities() {
        return dataBase;
    }

    private List<City> loadDefaultData() {
        City gdansk = new City(1, "gdansk");
        City bydgoszcz = new City(2, "bydgoszcz");
        City torun = new City(3, "torun");
        City warszawa = new City(4, "warszawa");

        gdansk.addNeighbor(bydgoszcz.getId(), 1);
        gdansk.addNeighbor(torun.getId(), 3);

        bydgoszcz.addNeighbor(gdansk.getId(), 1);
        bydgoszcz.addNeighbor(torun.getId(), 1);
        bydgoszcz.addNeighbor(warszawa.getId(), 4);

        torun.addNeighbor(gdansk.getId(), 3);
        torun.addNeighbor(bydgoszcz.getId(), 1);
        torun.addNeighbor(warszawa.getId(), 1);

        warszawa.addNeighbor(bydgoszcz.getId(), 4);
        warszawa.addNeighbor(torun.getId(), 1);

        return new ArrayList<>(List.of(gdansk, bydgoszcz, torun, warszawa));
    }
}
