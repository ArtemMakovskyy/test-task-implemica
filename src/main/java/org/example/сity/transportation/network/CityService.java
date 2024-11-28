package org.example.сity.transportation.network;

import java.util.ArrayList;
import java.util.List;

public class CityService {
    private final static List<City> cities
            = CityRepository.getInstance().getAllCities();
    /**
     * Finds and prints the minimum travel cost between two cities.
     *
     * @param fromCity the name of the starting city.
     * @param toCity the name of the destination city.
     */
    public static String findMinCostBetweenCities(
            String fromCity,
            String toCity)
    {
        City startCity = findCityByName(cities, fromCity);
        City endCity = findCityByName(cities, toCity);
        int minCost = findMinCostBetweenCities(
                startCity,
                endCity,
                new ArrayList<>(),
                0,
                cities);
        return "Minimum cost fromCity "
                + startCity.getName()
                + " toCity " + endCity.getName()
                + " is: " + minCost;
    }

    /**
     * Recursively calculates the minimum travel cost between two allCities.
     *
     * @param currentCity the current city.
     * @param destinationCity the destination city.
     * @param visitedCities list of allCities that have already been visited.
     * @param currentTravelCost the current accumulated travel cost.
     * @param allCities the complete list of allCities.
     * @return the minimum cost to reach the destination city.
     */
    private static int findMinCostBetweenCities(
            City currentCity,
            City destinationCity,
            List<City> visitedCities,
            int currentTravelCost,
            List<City> allCities) {
        // If the current city has already been visited, exit to avoid looping
        if (visitedCities.contains(currentCity)) {
            // Return the maximum value since the path cannot be selected
            return Integer.MAX_VALUE;
        }

        // If we have reached the target city, we return the cost of the current path
        if (currentCity == destinationCity) {
            return currentTravelCost;
        }

        // Add the current city to the list of visited allCities
        visitedCities.add(currentCity);

        int minCost = Integer.MAX_VALUE;

        // Recursively find the minimum cost for all neighbors
        for (Neighbor neighbor : currentCity.getNeighbors()) {
            City nextCity = getCityById(allCities, neighbor.getNeighborId());
            if (nextCity != null) {

                int pathCost = findMinCostBetweenCities(
                        nextCity,
                        destinationCity,
                        new ArrayList<>(visitedCities),
                        currentTravelCost + neighbor.getCost(),
                        allCities);

                minCost = Math.min(minCost, pathCost);
            }
        }
        return minCost;
    }

    /**
     * Finds a city by its name.
     *
     * @param allCities the list of all cities.
     * @param cityName the name of the city to find.
     * @return the city if found, otherwise null.
     */
    private static City findCityByName(List<City> allCities, String cityName) {
        for (City city : cities) {
            if (city.getName().equals(cityName)) {
                return city;
            }
        }
        return null;
    }

    /**
     * Finds a city by its ID.
     *
     * @param allCities the list of all cities.
     * @param cityId the ID of the city to find.
     * @return the city if found, otherwise null.
     */
    private static City getCityById(List<City> allCities, int cityId) {
        for (City city : allCities) {
            if (city.getId() == cityId) {
                return city;
            }
        }
        return null;
    }
}
