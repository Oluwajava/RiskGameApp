package com.soen.riskgame;

import com.soen.riskgame.module.core.constants.MapDelimiters;
import com.soen.riskgame.module.core.model.Map;
import com.soen.riskgame.utils.MapParser;
import com.soen.riskgame.utils.MapReader;
import com.soen.riskgame.utils.MapValidator;

public class Main {

    public static void main(String[] args) {
        try {
            MapReader mapReader = new MapReader("/Users/oluwajava/Development/RiskGame/src/maps/ameroki.map");
            String mapData = mapReader.readData().replaceAll(MapDelimiters.CARRIAGE_DELIMITER, "");
            MapValidator mapValidator = new MapValidator(mapData);
            mapValidator.validate();
            MapParser mapParser = new MapParser(mapData);
            Map.Data data = new Map.Builder(mapParser.getGameFile(), mapParser.getCountries(), mapParser.getContinentDTOS(), mapParser.getBorderDTOS()).build();

            System.out.println("==============================");
            System.out.println("        Continents            ");
            System.out.println("==============================");
            data.getContinents().entrySet().forEach(entry -> {
                System.out.println(entry.getValue().toString());
                System.out.println("Countries in Continent");
                entry.getValue().getCountries().forEach(country -> {
                    System.out.println(country.toString());
                });
                System.out.println("\n");
            });


            System.out.println("\n\n");
            System.out.println("==============================");
            System.out.println("        Countries             ");
            System.out.println("==============================");
            data.getCoutries().entrySet().forEach(entry -> {
                System.out.println(entry.getValue().toString());
                System.out.println("Adjacent Countries");
                entry.getValue().getAdjacentCountries().forEach(country -> {
                    System.out.println(country.toString());
                });
                System.out.println("\n");
            });

            System.out.println("Is Graph Connected: " + mapValidator.isGraphConnected(data));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
