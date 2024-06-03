package com.study_spring.ticketing.dto;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class PerformaceDTO {
    @Data
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    public static class responseDTO {
        @NotBlank(message = "데이터가 입력되지 않았습니다.")
        private String prf_name;
        @NotBlank(message = "데이터가 입력되지 않았습니다.")
        private String prf_cast;
        @NotBlank(message = "데이터가 입력되지 않았습니다.")
        private String prf_crew;
        @NotBlank(message = "데이터가 입력되지 않았습니다.")
        private String genre_name;
        @NotBlank(message = "데이터가 입력되지 않았습니다.")
        private Date prf_start;
        @NotBlank(message = "데이터가 입력되지 않았습니다.")
        private Date prf_end;
        @NotBlank(message = "데이터가 입력되지 않았습니다.")
        private String entrps_name;
        private String entrps_name_p;
        private String entrps_name_a;
        private String entrps_name_h;
        private String entrps_name_s;
        private String poster_url;
        private String prf_age;
    }
}
