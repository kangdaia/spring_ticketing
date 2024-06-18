package com.study_spring.ticketing.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import jakarta.persistence.Column;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class VenueDTO {

    @Data
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    public static class responseDTO {

        @Column(nullable = false, length = 100)
        @JacksonXmlProperty(localName = "")
        private String venue_id;

        @Column(nullable = false, length = 20)
        @JacksonXmlProperty(localName = "mt10id")
        private String location_id;

        @Column(nullable = false, length = 100)
        @JacksonXmlProperty(localName = "prfplcnm")
        private String venue_name;

        @Column(nullable = false, length = 10)
        @JacksonXmlProperty(localName = "seatscale")
        private String seat_scale;

        @Column(nullable = true)
        @JacksonXmlProperty(localName = "disabledseatscale")
        private Integer disabled_scale;

    }
}
