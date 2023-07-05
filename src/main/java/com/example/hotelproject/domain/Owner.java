package com.example.hotelproject.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Owner {
    private int userNo;
    private String userId;
    private String userPw;
    private String name;
    private String addr;
    private String mob;
    private String email;
    private int hotelNo;

    @Builder
    public Owner(int userNo,
                 String userId,
                 String userPw,
                 String name,
                 String addr,
                 String mob,
                 String email,
                 int hotelNo) {
        this.userNo = userNo;
        this.userId = userId;
        this.userPw = userPw;
        this.name = name;
        this.addr = addr;
        this.mob = mob;
        this.email = email;
        this.hotelNo = hotelNo;
    }

    protected Owner() {

    }
}
