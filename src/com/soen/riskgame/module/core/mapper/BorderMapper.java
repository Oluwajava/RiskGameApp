package com.soen.riskgame.module.core.mapper;

import com.soen.riskgame.module.core.constants.MapDelimiters;
import com.soen.riskgame.module.core.model.BorderDTO;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BorderMapper {

    public static BorderDTO mapToBorder(String data) {
        String[] borderData = data.split(MapDelimiters.SPACE_DELIMITER);
        BorderDTO borderDTO = new BorderDTO();
        borderDTO.setCountryId(Long.valueOf(borderData[0]));
        List<Long> adjacentCountries = Arrays.stream(borderData).map(Long::valueOf).collect(Collectors.toList());
        adjacentCountries.remove(borderDTO.getCountryId());
        borderDTO.setAdjacentCountries(adjacentCountries);
        return borderDTO;
    }
}
