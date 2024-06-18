package com.study_spring.ticketing.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study_spring.ticketing.dto.PerformanceDTO;
import com.study_spring.ticketing.dto.PerformanceDTO.CreateDTO;
import com.study_spring.ticketing.service.PerformanceService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/performace")
public class PerformaceController {
    private final PerformanceService performanceService;

    public PerformaceController(PerformanceService performanceService) {
        this.performanceService = performanceService;
    }

    @GetMapping("/fetch-data")
    public ResponseEntity<Object> fetchData(@RequestParam String param) {
        List<PerformanceDTO.CreateDTO> result = performanceService.fetchPrfData("20240401", "20240501", 1);
        return ResponseEntity.ok(result);
        //return ResponseEntity.ok("Performance Data fetched and saved successfully");
    }
}
