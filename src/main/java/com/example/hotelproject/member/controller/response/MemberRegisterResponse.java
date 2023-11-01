package com.example.hotelproject.member.controller.response;

import com.example.hotelproject.member.entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Getter
@ToString
public class MemberRegisterResponse {

    private String name;

    @Builder
    public MemberRegisterResponse(String name) {
        this.name = name;
    }

    public Member toEntity(String name) {
        return Member.builder()
                .name(name)
                .build();
    }

}
