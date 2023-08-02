package com.example.hotelproject.controller.request;


import com.example.hotelproject.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor
public class UserRegisterRequest {
    private String name;
    private String userId;
    private String password;
    private String email;
    private String mobile;
    private String address;
    private int age;

    @Builder
    public UserRegisterRequest(String name, String userId, String password, String email,
        String mobile, String address, int age) {
        this.name = name;
        this.userId = userId;
        this.password = password;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
        this.age = age;
    }

    public User toEntity(String password){
        return User.builder()
            .userId(userId)
            .password(password)
            .email(email)
            .name(name)
            .address(address)
            .age(age)
            .mobile(mobile)
            .build();
    }
}
