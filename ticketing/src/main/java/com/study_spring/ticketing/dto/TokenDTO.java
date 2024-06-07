package com.study_spring.ticketing.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TokenDTO {

    private String grantType;
    private String accessToken;
    private String refreshToken;
    private long accessTokenExpiresIn;
    private String key;

}
