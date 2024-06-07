package com.study_spring.ticketing.util;


import com.study_spring.ticketing.exception.UnAuthorizationException;
import com.study_spring.ticketing.jwt.TokenProvider;
import com.study_spring.ticketing.repository.BlackListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class RefreshTokenValidator {

    private final TokenProvider tokenProvider;
    private final BlackListRepository blackListRepository;

    public void validateToken(String refreshToken) {
        if (!tokenProvider.validateToken(refreshToken)) {
            throw new UnAuthorizationException("[ERROR] 유효하지 않은 Refresh Token입니다!");
        }
    }

    public void validateTokenOwnerId(String refreshToken, String username) {
        final String getUsername = tokenProvider.extractSubject(refreshToken);
        if (!getUsername.equals(username)) {
            throw new UnAuthorizationException("[ERROR] 로그인한 사용자의 Refresh Token이 아닙니다!");
        }
    }

    public void validateLogoutToken(String refreshToken) {
        if (blackListRepository.existsByInvalidRefreshToken(refreshToken)) {
            throw new UnAuthorizationException("[ERROR] 이미 로그아웃된 사용자입니다!");
        }
    }
}