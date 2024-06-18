package com.study_spring.ticketing.service;

import com.study_spring.ticketing.domain.Authority;
import com.study_spring.ticketing.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.lenient;

@ExtendWith(MockitoExtension.class)
class CustomUserDetailsServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private CustomUserDetailsService userDetailsService;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    @DisplayName("로그인 성공")
    void testLoadUserByUsername() {
        String username = "testUser";
        String password = "passWord1234";
        Authority authority = Authority.builder()
                .authorityName("ROLE_USER")
                .build();
        User user = new User(username, password, Collections.singleton((GrantedAuthority) authority));
//        lenient().when(userRepository.findOneWithAuthoritiesByUsername(username)).thenReturn(?));


    }
    @Test
    @DisplayName("로그인 서비스 실패 - 존재하지 않는 사용자")
    void testLoadUserByUsernameWithNonExistingUser(){
        String username = "notExistingUser";
        lenient().when(userRepository.findOneWithAuthoritiesByUsername(username)).thenReturn(Optional.empty());
        assertThrows(UsernameNotFoundException.class, () -> userDetailsService.loadUserByUsername(username),
                "Should throw an exception for not existing username");
    }



    @Test
    @DisplayName("로그인 서비스 실패 - 비활성화 상태인 사용자")
    void testLoadUserByUsernameWithInactivatedUser() {
        String username = "inactivatedUser";
        lenient().when(userRepository.findOneWithAuthoritiesByUsername(username)).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> userDetailsService.loadUserByUsername(username),
                "Should throw an exception for inactivated username ");

    }

}