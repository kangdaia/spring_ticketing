package com.study_spring.ticketing.dto;

import jakarta.persistence.Column;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class LocationDTO {
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    public static class responseDTO {
        @Column(nullable = false, length = 20)
        private String location_id;
        @Column(nullable = false, length = 100)
        private String loc_name;
        @Column(nullable = false, length = 4)
        private String areacode;
        @Column(nullable = false, length = 4)
        private String sigungucodesub;
        @Column(nullable = false)
        private Integer venue_cnt;
        @Column(nullable = false, length = 100)
        private String address;
        @Column(nullable = false)
        private Double latitude;
        @Column(nullable = false)
        private Double longitude;
    }
}
