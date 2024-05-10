package com.study_spring.ticketing.dto;

import lombok.*;

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

    public static UserCreateDTO toUserDTO(User user) {
        return UserCreateDTO.builder()
                .email(user.getEmail())
                .phone(user.getPhone())
                .password(user.getPassword())
                .username(user.getUsername())
                .build();
    }
}
