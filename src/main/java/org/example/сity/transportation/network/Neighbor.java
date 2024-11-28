package org.example.сity.transportation.network;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Neighbor {
    private int neighborId;
    private int cost;

    public Neighbor(int neighborId, int cost) {
        this.neighborId = neighborId;
        this.cost = cost;
    }
}
