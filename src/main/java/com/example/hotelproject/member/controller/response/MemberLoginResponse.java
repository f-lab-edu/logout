package com.example.hotelproject.member.controller.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Getter
@ToString
public class MemberLoginResponse {

    private String token;

    @Builder
    public MemberLoginResponse(String token) {
        this.token = token;
    }
}
