package com.example.hotelproject.controller.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Getter
@ToString
public class UserLoginResponse {
    private String token;

    @Builder
    public UserLoginResponse(String token) {
        this.token = token;
    }
}
