package com.study_spring.ticketing.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.study_spring.ticketing.domain.User;

@Data
@NoArgsConstructor
public class UserCreateDTO {
    private String username;
    private String password;
    private String email;
    private String phone;

    @Builder
    public UserCreateDTO(String username, String password, String email, String phone) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

    public User toEntity() {
        return User.builder()
                .username(username)
                .password(password)
                .email(email)
                .phone(phone)
                .build();
    }
}
