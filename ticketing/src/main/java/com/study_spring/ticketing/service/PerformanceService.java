package com.study_spring.ticketing.service;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import com.study_spring.ticketing.config.APIConfig;
import com.study_spring.ticketing.domain.Performance;
import com.study_spring.ticketing.dto.PerformanceDTO;
import com.study_spring.ticketing.repository.PerformanceRepository;
import com.study_spring.ticketing.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class PerformanceService {
    private final PerformanceRepository  performanceRepository;
    private final WebClient webClient;
    private final APIConfig apiConfig;

    public PerformanceService(WebClient.Builder builder, APIConfig apiConfig, PerformanceRepository performanceRepository) {
        this.performanceRepository = performanceRepository;
        this.apiConfig = apiConfig;
        this.webClient = builder
                        .baseUrl(apiConfig.getBaseurl())
                        .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .build();
    }

    public List<PerformanceDTO.CreateDTO> fetchPrfData(String stdate, String eddate, Integer page) {
        String apikey = apiConfig.getKey();
        List<PerformanceDTO.CreateDTO> data = webClient.get()
                                                .uri(UriBuilder -> 
                                                        UriBuilder.path("/pblprfr")
                                                            .queryParam("service", apikey)
                                                            .queryParam("stdate", stdate)
                                                            .queryParam("eddate", eddate)
                                                            .queryParam("cpage", page)
                                                            .queryParam("rows", 100).build())
                                                .retrieve()
                                                .bodyToFlux(PerformanceDTO.CreateDTO.class)
                                                .collectList()
                                                .block();
        return data;
    }

//    @Transactional
//    public PerformanceDTO.CreateDTO createPerformance(PerformanceDTO.CreateDTO performanceCreateDTO) {
//        Performance performance = Performance.builder()
//                .prf_name(performanceCreateDTO.getPrfName())
//                .prf_cast(performanceCreateDTO.getPrfCast())
//                .prf_crew(performanceCreateDTO.getPrfCrew())
//                .genre_name(performanceCreateDTO.getGenreName())
//                .prf_start(performanceCreateDTO.getPrfStart())
//                .prf_end(performanceCreateDTO.getPrfEnd())
//                .entrps_name(performanceCreateDTO.getEntrpsName())
//                .entrps_name_p(performanceCreateDTO.getEntrpsNameP())
//                .entrps_name_a(performanceCreateDTO.getEntrpsNameA())
//                .entrps_name_h(performanceCreateDTO.getEntrpsNameH())
//                .entrps_name_s(performanceCreateDTO.getEntrpsNameS())
//                .poster_url(performanceCreateDTO.getPosterUrl())
//                .prf_age(performanceCreateDTO.getPrfAge())
//                .venue(performanceCreateDTO.getVenue())
//                .prfSession(performanceCreateDTO.getPrfSession())
//                .prfPrice(performanceCreateDTO.getPrfPrice())
//                .build();
//        return performanceRepository.save(performance);
//    }
}
