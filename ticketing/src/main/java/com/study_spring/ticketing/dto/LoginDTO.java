package com.study_spring.ticketing.dto;

import lombok.*;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {

    @NotNull(message = "username이 입력되지 않았습니다.")
    @Size(min = 3, max = 50)
    private String username;

    @NotNull(message = "비밀번호가 입력되지 않았습니다.")
    @Size(min = 3, max = 100)
    private String password;
}