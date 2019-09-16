package com.soen.riskgame.utils;

import com.soen.riskgame.module.core.constants.MapDelimiters;
import com.soen.riskgame.module.core.model.BorderDTO;
import com.soen.riskgame.module.core.model.ContinentDTO;
import com.soen.riskgame.module.core.model.CountryDTO;
import com.soen.riskgame.module.core.model.GameFile;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static com.soen.riskgame.module.core.mapper.BorderMapper.mapToBorder;
import static com.soen.riskgame.module.core.mapper.ContinentMapper.mapToContinent;
import static com.soen.riskgame.module.core.mapper.CountryMapper.mapToCountry;


@Getter
public class MapParser {

    private GameFile gameFile;

    private List<ContinentDTO> continentDTOS;

    private List<CountryDTO> countries;

    private List<BorderDTO> borderDTOS;

    public MapParser(String mapData) throws Exception {
        if (mapData == null || mapData.length() == 0) {
            throw new Exception("Invalid data size");
        }
        gameFile = new GameFile();
        continentDTOS = new ArrayList<>();
        countries = new ArrayList<>();
        borderDTOS = new ArrayList<>();
        processData(mapData);
    }

    private void processData(String mapData) {
        String[] lines = mapData.split(MapDelimiters.NEXT_LINE_DELIMETER);
        String currentDelimeter = "";
        for (String line : lines) {
            if (line.trim().equals(MapDelimiters.FILE_DELIMITER) || currentDelimeter.equals(MapDelimiters.FILE_DELIMITER)) {
                currentDelimeter = MapDelimiters.FILE_DELIMITER;
                if (isSectionContent(line, currentDelimeter) && StringUtils.isNotBlank(line)) {

                }
            }
            if (line.trim().equals(MapDelimiters.BORDER_DELIMETER) || currentDelimeter.equals(MapDelimiters.BORDER_DELIMETER)) {
                currentDelimeter = MapDelimiters.BORDER_DELIMETER;
                if (isSectionContent(line, currentDelimeter) && StringUtils.isNotBlank(line)) {
                    borderDTOS.add(mapToBorder(line));
                }
            }

            if (line.trim().equals(MapDelimiters.CONTINENT_DELIMETER) || currentDelimeter.equals(MapDelimiters.CONTINENT_DELIMETER)) {
                currentDelimeter = MapDelimiters.CONTINENT_DELIMETER;
                if (isSectionContent(line, currentDelimeter) && StringUtils.isNotBlank(line)) {
                    continentDTOS.add(mapToContinent(line));
                }
            }

            if (line.trim().equals(MapDelimiters.COUNTRY_DELIMETER) || currentDelimeter.equals(MapDelimiters.COUNTRY_DELIMETER)) {
                currentDelimeter = MapDelimiters.COUNTRY_DELIMETER;
                if (isSectionContent(line, currentDelimeter) && StringUtils.isNotBlank(line)) {
                    countries.add(mapToCountry(line));
                }
            }
        }
        System.out.println();
    }

    private void addDataToList(String currentDelimiter, List<String> files, String line) {
        if (isSectionContent(line, currentDelimiter) && StringUtils.isNotBlank(line)) {
            files.add(line.trim());
        }
    }

    private boolean isSectionContent(String line, String currentDelimeter) {
        return !(line.trim().equals(MapDelimiters.BORDER_DELIMETER)) && !(line.trim().equals(MapDelimiters.CONTINENT_DELIMETER)) &&
            !(line.trim().equals(MapDelimiters.COUNTRY_DELIMETER)) && !(line.trim().equals(MapDelimiters.NEXT_LINE_DELIMETER)) &&
            !(line.trim().equals(currentDelimeter));
    }


}
