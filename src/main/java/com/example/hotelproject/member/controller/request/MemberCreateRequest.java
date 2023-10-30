package com.example.hotelproject.member.controller.request;


import com.example.hotelproject.member.entity.Member;
import com.example.hotelproject.security.UserRoleEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor
public class MemberCreateRequest {

    private Long memberId;
    private String name;
    private String password;
    private String email;
    private String mobile;
    private String address;
    private int age;
    private UserRoleEnum role;

    @Builder
    public MemberCreateRequest(Long memberId, String name, String password, String email,
            String mobile,
            String address, int age, UserRoleEnum role) {
        this.memberId = memberId;
        this.name = name;
        this.password = password;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
        this.age = age;
        this.role = role;
    }

    public Member toEntity() {
        return Member.builder()
                .password(password)
                .email(email)
                .name(name)
                .address(address)
                .age(age)
                .mobile(mobile)
                .build();
    }
}
