package com.dtokens.digital_token.response;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class JwtAuthResponse {
    private String accessToken;
    private String tokenType;

    public JwtAuthResponse(String accessToken) {
        this.accessToken = accessToken;
    }
}
