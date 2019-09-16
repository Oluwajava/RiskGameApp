package com.soen.riskgame.module.core.mapper;

import com.soen.riskgame.module.core.constants.MapDelimiters;
import com.soen.riskgame.module.core.model.CountryDTO;

public class CountryMapper {

    public static CountryDTO mapToCountry(String data) {
        String[] countryData = data.split(MapDelimiters.SPACE_DELIMITER);
        CountryDTO countryDTO = new CountryDTO();
        countryDTO.setId(Long.valueOf(countryData[0]));
        countryDTO.setName(countryData[1]);
        countryDTO.setContinentId(countryData[2]);
        countryDTO.setXCoordinate(countryData[3]);
        countryDTO.setYCoordinate(countryData[4]);
        return countryDTO;
    }

}
