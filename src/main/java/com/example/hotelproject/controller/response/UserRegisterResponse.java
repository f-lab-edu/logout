package com.example.hotelproject.controller.response;

import com.example.hotelproject.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Getter
@ToString
public class UserRegisterResponse {
    private String name;

    @Builder
    public UserRegisterResponse(String name) {
        this.name = name;
    }

    public User toEntity(String name){
        return User.builder()
            .name(name)
            .build();
    }

}
