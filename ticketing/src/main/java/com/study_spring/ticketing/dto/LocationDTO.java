package com.study_spring.ticketing.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import jakarta.persistence.Column;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
public class LocationDTO {

    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    public static class responseDTO {
        @Column(nullable = false, length = 20)
        @JacksonXmlProperty(localName = "mt10id")
        private String location_id;

        @Column(nullable = false, length = 100)
        @JacksonXmlProperty(localName = "fcltynm")
        private String loc_name;


        @Column(nullable = false, length = 4)
        @JacksonXmlProperty(localName = "sidonm")
        private String sidonm;

        @Column(nullable = false, length = 4)
        @JacksonXmlProperty(localName = "gugunnm")
        private String gugunnm;

        @Column(nullable = false)
        @JacksonXmlProperty(localName = "mt13cnt")
        private Integer venue_cnt;


//        @Column(nullable = false, length = 100)
//        private String address;
//        @Column(nullable = false)
//        private Double latitude;
//        @Column(nullable = false)
//        private Double longitude;
    }
}
