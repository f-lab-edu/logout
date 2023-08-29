package com.example.hotelproject.controller.response.user;

import com.example.hotelproject.domain.User;
import lombok.*;

@ToString
@Getter
@NoArgsConstructor
public class UserResponse {
    private String name;
    private String userId;
    private String email;
    private String mobile;
    private String address;
    private int age;

    @Builder
    public UserResponse(String name, String userId, String email, String mobile,
        String address, int age) {
        this.name = name;
        this.userId = userId;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
        this.age = age;
    }

    public static UserResponse of(User user){
        return UserResponse.builder()
            .userId(user.getUserId())
            .name(user.getName())
            .email(user.getEmail())
            .mobile(user.getMobile())
            .address(user.getAddress())
            .age(user.getAge())
            .build();
    }
}
