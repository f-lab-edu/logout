package com.example.hotelproject.sign;

import com.example.hotelproject.member.entity.Member;
import com.example.hotelproject.security.MemberRoleEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SignResponse {

    private String email;
    private String token;
    private MemberRoleEnum role;

    @Builder
    public SignResponse(String email, String token, MemberRoleEnum role) {
        this.email = email;
        this.token = token;
        this.role = role;
    }

    public static SignResponse of(Member member) {
        return SignResponse.builder()
                .email(member.getEmail())
                .role(member.getRole())
                .build();
    }

    public void setToken(String token) {
        this.token = token;
    }
}
