package com.study_spring.ticketing.service;

import com.study_spring.ticketing.dto.TokenDTO;
import com.study_spring.ticketing.jwt.TokenProvider;
import com.study_spring.ticketing.util.RefreshTokenValidator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Transactional
public class ReissueTokenService {

    private final TokenProvider tokenProvider;
    private final RefreshTokenValidator refreshTokenValidator;

    public TokenDTO reissueToken(final String refreshToken) {
        refreshTokenValidator.validateToken(refreshToken);
        refreshTokenValidator.validateLogoutToken(refreshToken);
        final String Username = tokenProvider.extractSubject(refreshToken);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return tokenProvider.createToken(authentication);
    }
}
