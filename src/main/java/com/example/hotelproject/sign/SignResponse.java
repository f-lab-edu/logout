package com.example.hotelproject.sign;

import com.example.hotelproject.security.UserRoleEnum;
import com.example.hotelproject.user.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SignResponse {

    private String userId;
    private String token;
    private UserRoleEnum role;

    @Builder
    public SignResponse(String userId, String token, UserRoleEnum role) {
        this.userId = userId;
        this.token = token;
        this.role = role;
    }

    public static SignResponse of(User user) {
        return SignResponse.builder()
                .userId(user.getUserId())
                .role(user.getRole())
                .build();
    }

    public void setToken(String token) {
        this.token = token;
    }
}
