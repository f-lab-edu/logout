package com.example.hotelproject.domain;

import lombok.Builder;
import lombok.Getter;


//table 1:1
//create basic select update DB 작업에 사용
@Getter
public class User {
    private String userName;
    private String userId;
    private String phoneNumber;
    private int age;

    @Builder
    public User(String userName,
                String userId,
                String phoneNumber,
                int age) {
        this.userName = userName;
        this.userId = userId;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }
}
