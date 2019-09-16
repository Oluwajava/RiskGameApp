package com.soen.riskgame.module.core.mapper;

import com.soen.riskgame.module.core.constants.MapDelimiters;
import com.soen.riskgame.module.core.model.ContinentDTO;

public class ContinentMapper {

    public static ContinentDTO mapToContinent(String data) {
        String[] continentData = data.split(MapDelimiters.SPACE_DELIMITER);
        ContinentDTO continentDTO = new ContinentDTO();
        continentDTO.setName(continentData[0]);
        continentDTO.setControlValue(Integer.valueOf(continentData[1]));
        continentDTO.setColor(continentData[2]);
        return continentDTO;
    }

}
