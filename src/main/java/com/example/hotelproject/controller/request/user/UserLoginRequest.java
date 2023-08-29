package com.example.hotelproject.controller.request.user;


import com.example.hotelproject.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor
public class UserLoginRequest {
    private String userId;
    private String password;

    @Builder
    public UserLoginRequest(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public User toEntity(){
        return User.builder()
            .userId(userId)
            .password(password)
            .build();
    }
}
