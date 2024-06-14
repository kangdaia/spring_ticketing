package com.study_spring.ticketing.controller;

import com.study_spring.ticketing.dto.LocationDTO;
import com.study_spring.ticketing.service.PrfPlcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api")
public class PrfplcController {

    private final PrfPlcService prfplcService;

    @Autowired
    public PrfplcController(PrfPlcService prfplcService) {
        this.prfplcService = prfplcService;
    }

//    @GetMapping("/getPrfPlcList")
//    public ResponseEntity<List<LocationDTO.responseDTO>> getData(Model model) throws Exception {
//        Mono<String> response = prfplcService.getData();
//        List<LocationDTO.responseDTO> locationList = prfplcService.PrfPlcApiParseXml(response);
//        return new ResponseEntity<>(locationList, HttpStatus.OK);
//    }
    @GetMapping("/test")
    public Flux<LocationDTO.responseDTO> getData() {
        return prfplcService.getData();
    }

}
