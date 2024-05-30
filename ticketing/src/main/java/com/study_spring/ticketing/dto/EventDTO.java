package com.study_spring.ticketing.dto;

import jakarta.persistence.Column;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class EventDTO {
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    public static class responseDTO {
        @Column(nullable = false, length = 100)
        private String event_name;
        @Column(nullable = false, columnDefinition = "TEXT")
        private String description;
        @Column(nullable = false, length = 100)
        private String category;
        @Column(nullable = false, length = 100)
        private String event_state;
    }
}
