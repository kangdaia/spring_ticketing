package com.study_spring.ticketing.controller;

import com.study_spring.ticketing.dto.TokenDTO;
import com.study_spring.ticketing.service.ReissueTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class ReissueTokenController {

    private final ReissueTokenService reissueTokenService;

    @GetMapping("/reissue-token")
    public ResponseEntity<TokenDTO> reissueToken(
            @RequestHeader("Refresh") String refreshToken
    ) {
        return ResponseEntity.ok(reissueTokenService.reissueToken(refreshToken));
    }
}
