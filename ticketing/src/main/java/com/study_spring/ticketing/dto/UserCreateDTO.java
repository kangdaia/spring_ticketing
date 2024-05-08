package com.study_spring.ticketing.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.study_spring.ticketing.domain.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserCreateDTO {
    @NotBlank(message = "username이 입력되지 않았습니다.")
    private String username;
    @NotBlank(message = "비밀번호가 입력되지 않았습니다.")
    private String password;
    @NotBlank(message = "이메일이 입력되지 않았습니다.")
    @Email(message = "이메일 양식이 일치하지 않습니다.")
    private String email;
    @Pattern(regexp = "^\\\\d{2,3}-\\\\d{3,4}-\\\\d{4}$", message = "핸드폰 번호 양식이 일치하지 않습니다.")
    @NotBlank(message = "전화번호가 입력되지 않았습니다.")
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
