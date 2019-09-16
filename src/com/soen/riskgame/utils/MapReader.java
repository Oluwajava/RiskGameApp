package com.soen.riskgame.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MapReader {


    private String mapLocation;

    public MapReader(String mapLocation) throws Exception {
        if (mapLocation == null) {
            throw new Exception("Map address cannot be empty!");
        }
        this.mapLocation = mapLocation;
    }

    public String readData() {
        String list = null;
        try (BufferedReader br = Files.newBufferedReader(Paths.get(mapLocation))) {
            list = new String(Files.readAllBytes(Paths.get(mapLocation)), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
