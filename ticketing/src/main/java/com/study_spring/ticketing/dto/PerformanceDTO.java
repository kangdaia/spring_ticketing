package com.study_spring.ticketing.dto;

import java.util.Date;
import java.util.List;

import com.study_spring.ticketing.domain.PRFPrice;
import com.study_spring.ticketing.domain.PRFSession;
import com.study_spring.ticketing.domain.Venue;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class PerformanceDTO {
    @Data
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    public static class APIRequestDTO {
        private String apikey;
        private String stdate;
        private String eddate;
        private String cpage;
        private String rows;
    }

    @Data
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    public static class CreateDTO {
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
        private Date updateAt;
        //private Venue venue;
        //private List<PRFSession> prfSession;
        //private List<PRFPrice> prfPrice;
    }
}
