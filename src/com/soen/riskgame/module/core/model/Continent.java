package com.soen.riskgame.module.core.model;

import lombok.Data;

import java.util.List;

@Data
public class Continent {

    private Long id;

    private String name;

    private int controlValue;

    private String color;

    private List<Country> countries;

    public Continent(String name, int controlValue, String color) {
        this.name = name;
        this.controlValue = controlValue;
        this.color = color;
    }


    @Override
    public String toString() {
        return "Continent{" +
                "name='" + name + '\'' +
                ", controlValue=" + controlValue +
                ", color='" + color + '\'' +
                '}';
    }
}
