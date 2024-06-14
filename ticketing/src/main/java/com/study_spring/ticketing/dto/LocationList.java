package com.study_spring.ticketing.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class LocationList {

    @JacksonXmlElementWrapper(localName = "dbs")
    @JacksonXmlProperty(localName = "db")
    private List<LocationDTO.responseDTO> locationList;

}
