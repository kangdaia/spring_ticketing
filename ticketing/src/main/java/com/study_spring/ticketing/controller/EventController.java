package com.study_spring.ticketing.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/event")
public class EventController {
    @GetMapping("/fetch-data")
    public String fetchData(@RequestParam String param) {
        // url 호출
        return new String();
    }
}
