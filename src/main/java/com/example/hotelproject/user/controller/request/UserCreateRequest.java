package com.example.hotelproject.user.controller.request;


import com.example.hotelproject.user.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor
public class UserCreateRequest{
    private Long userNo;
    private String name;
    private String userId;
    private String password;
    private String email;
    private String mobile;
    private String address;
    private int age;

    @Builder
    public UserCreateRequest(Long userNo, String name, String userId, String password,
        String email, String mobile, String address, int age) {
        this.userNo = userNo;
        this.name = name;
        this.userId = userId;
        this.password = password;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
        this.age = age;
    }

    public User toEntity(){
        return User.builder()
            .userId(userId)
            .userNo(userNo)
            .password(password)
            .email(email)
            .name(name)
            .address(address)
            .age(age)
            .mobile(mobile)
            .build();
    }
}
