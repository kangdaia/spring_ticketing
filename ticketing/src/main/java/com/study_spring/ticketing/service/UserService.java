package com.study_spring.ticketing.service;

import com.study_spring.ticketing.dto.UserCreateDTO;
import com.study_spring.ticketing.repository.UserRepository;
import com.study_spring.ticketing.domain.User;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

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


    public UserCreateDTO login(UserCreateDTO userCreateDTO) {
        /*
            1. 회원이 입력한 이메일로 DB에서 조회를 함
            2. DB에서 조회한 비밀번호와 사용자가 입력한 비밀번호가 일치하는지 판단
         */
        Optional<User> byEmail = userRepository.findByEmail(userCreateDTO.getEmail());
        if (byEmail.isPresent()) {
            // 조회 결과가 있다면 (해당 이메일을 가진 회원 정보가 있다면)
            User user = byEmail.get();
            if (user.getPassword().equals(userCreateDTO.getPassword())) {
                // 비밀번호 일치
                // entity -> dto 변환 후 리턴
                UserCreateDTO dto = UserCreateDTO.toUserDTO(user);
                return dto;
            } else {
                // 비밀번호 불일치
                return null;
            }
        } else {
            // 조회 결과가 없다면
            return null;
        }
    }

}