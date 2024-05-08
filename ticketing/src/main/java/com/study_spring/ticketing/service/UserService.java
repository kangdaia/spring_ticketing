package com.study_spring.ticketing.service;

import com.study_spring.ticketing.domain.User;
import com.study_spring.ticketing.dto.UserCreateDTO;
import com.study_spring.ticketing.repository.UserRepository;

import jakarta.transaction.Transactional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UserService implements UserDetailsService {
    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public UserCreateDTO createUser(UserCreateDTO userCreateDTO) {
        validateDuplicateUsername(userCreateDTO);
        validateDuplicateEmail(userCreateDTO);
        String rawPassword = userCreateDTO.getPassword();
        String encodedPassword = passwordEncoder.encode(rawPassword);
        userCreateDTO.setPassword(encodedPassword);
        userRepository.save(userCreateDTO.toEntity());
        return userCreateDTO;
    }

    private void validateDuplicateUsername(UserCreateDTO userCreateDTO) {
        userRepository.findByUsername(userCreateDTO.getUsername())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    private void validateDuplicateEmail(UserCreateDTO userCreateDTO) {
        userRepository.findByEmail(userCreateDTO.getEmail())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 가입된 이메일입니다.");
                });
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'loadUserByUsername'");
    }

}