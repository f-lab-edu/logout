package com.example.hotelproject.controller.response;

import lombok.*;

@ToString
@Getter
@NoArgsConstructor
public class UserResponse {
    private String userName;
    private String userId;
    private String phoneNumber;
    private int age;

    @Builder
    public UserResponse(String userName,
                             String userId,
                             String phoneNumber,
                             int age) {
        this.userName = userName;
        this.userId = userId;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }
}
