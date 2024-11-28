package org.example.сity.transportation.network;


import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class City {
    private int id;
    private String name;
    private List<Neighbor> neighbors;

    public City(int id, String name) {
        this.id = id;
        this.name = name;
        this.neighbors = new ArrayList<>();
    }

    public void addNeighbor(int neighborId, int cost) {
        this.neighbors.add(new Neighbor(neighborId, cost));
    }
}
