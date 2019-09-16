package com.soen.riskgame.utils;

import com.soen.riskgame.module.core.constants.MapDelimiters;
import com.soen.riskgame.module.core.model.Continent;
import com.soen.riskgame.module.core.model.Map;

import java.util.HashSet;

public class MapValidator {

    private String mapData;

    public MapValidator(String mapData) throws Exception {
        if (mapData == null || mapData.length() == 0) {
            throw new Exception("Invalid data size");
        }
        this.mapData = mapData;
    }

    public void validate() throws Exception {
        checkAllTags();
    }

    private void checkAllTags() throws Exception {
        if (!mapData.contains(MapDelimiters.BORDER_DELIMETER)) {
            throw new Exception("Cannot find BorderDTO for Map");
        }

        if (!mapData.contains(MapDelimiters.CONTINENT_DELIMETER)) {
            throw new Exception("Cannot find ContinentDTO for Map");
        }

        if (!mapData.contains(MapDelimiters.COUNTRY_DELIMETER)) {
            throw new Exception("Cannot find CountryDTO for Map");
        }

        if (!mapData.contains(MapDelimiters.FILE_DELIMITER)) {
            throw new Exception("Canont find File Data for Map");
        }
    }

    public boolean isGraphConnected(Map.Data data) {
        boolean connected = GraphUtil.isGraphConnected(new HashSet<>(data.getCoutries().values()));
        connected = isCountriesInContinentsConnected(data, connected);
        return connected;
    }

    private boolean isCountriesInContinentsConnected(Map.Data data, boolean connected) {
        for (java.util.Map.Entry<String, Continent> continent : data.getContinents().entrySet()) {
           connected = GraphUtil.isGraphConnected(new HashSet<>(continent.getValue().getCountries()));
        }
        return connected;
    }
}
