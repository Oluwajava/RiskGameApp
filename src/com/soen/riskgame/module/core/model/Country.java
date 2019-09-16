package com.soen.riskgame.module.core.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Country {

    private Long id;

    private String name;

    private Player player;

    private String continentId;

    private Continent continent;

    private String xCoordinate;

    private String yCoordinate;

    private int noOfArmies;

    private List<Country> adjacentCountries;

    public Country(String name) {
        this.name = name;
        adjacentCountries = new ArrayList<>();
    }

    public Country(Long id, String name, String xCoordinate, String yCoordinate) {
        this.id = id;
        this.name = name;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }
}
