package com.example.hotelproject.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Owner {
    private int userNo;
    private String userId;
    private String userPassword;
    private String name;
    private String address;
    private String mobile;
    private String email;
    private int hotelNo;

    @Builder
    public Owner(int userNo, String userId, String userPassword, String name, String address, String mobile, String email, int hotelNo) {
        this.userNo = userNo;
        this.userId = userId;
        this.userPassword = userPassword;
        this.name = name;
        this.address = address;
        this.mobile = mobile;
        this.email = email;
        this.hotelNo = hotelNo;
    }

}
