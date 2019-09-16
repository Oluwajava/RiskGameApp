package com.soen.riskgame.module.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryDTO {

    private Long id;

    private String name;

    private String continentId;

    private ContinentDTO continentDTO;

    private String yCoordinate;

    private String xCoordinate;

}
