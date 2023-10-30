package com.example.hotelproject.member.controller.response;

import com.example.hotelproject.member.entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor
public class MemberResponse {
    private String name;
    private Long memberId;
    private String email;
    private String mobile;
    private String address;
    private int age;

    @Builder
    public MemberResponse(String name, String email, String mobile,
        String address, int age) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
        this.age = age;
    }

    public static MemberResponse of(Member member){
        return MemberResponse.builder()
            .name(member.getName())
            .email(member.getEmail())
            .mobile(member.getMobile())
            .address(member.getAddress())
            .age(member.getAge())
            .build();
    }
}
