package com.study_spring.ticketing.service;

import com.study_spring.ticketing.domain.BlackList;
import com.study_spring.ticketing.repository.BlackListRepository;
import com.study_spring.ticketing.util.RefreshTokenValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class UserLogoutService{

    private final BlackListRepository blackListRepository;
    private final RefreshTokenValidator refreshTokenValidator;


    public void logout(String username, String refreshToken) {

        // refresh token 유효성 검증 후 black list에 저장
        refreshTokenValidator.validateToken(refreshToken);
//        refreshTokenValidator.validateTokenOwnerId(refreshToken, username);
        refreshTokenValidator.validateLogoutToken(refreshToken);
        blackListRepository.save(new BlackList(refreshToken));

    }
}
