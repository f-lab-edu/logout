package com.example.hotelproject.member.controller.request;


import com.example.hotelproject.user.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor
public class MemberRegisterRequest {

    private String name;
    private Long memberId;
    private String password;
    private String email;
    private String mobile;
    private String address;
    private int age;

    @Builder
    public MemberRegisterRequest(String name, Long memberId, String password, String email,
            String mobile, String address, int age) {
        this.name = name;
        this.memberId = memberId;
        this.password = password;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
        this.age = age;
    }

    public User toEntity(String password) {
        return User.builder()
                .password(password)
                .email(email)
                .name(name)
                .address(address)
                .age(age)
                .mobile(mobile)
                .build();
    }
}
