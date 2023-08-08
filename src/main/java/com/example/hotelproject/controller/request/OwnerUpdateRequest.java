package com.example.hotelproject.controller.request;


import com.example.hotelproject.domain.Owner;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor
public class OwnerUpdateRequest {
    private Long userNo;
    private String name;
    private String userId;
    private String password;
    private String email;
    private String mobile;
    private String address;

    @Builder
    public OwnerUpdateRequest(Long userNo, String name, String userId, String password,
        String email, String mobile, String address) {
        this.userNo = userNo;
        this.name = name;
        this.userId = userId;
        this.password = password;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
    }

    public Owner toEntity(){
        return Owner.builder()
            .userId(userId)
            .userNo(userNo)
            .password(password)
            .email(email)
            .name(name)
            .address(address)
            .mobile(mobile)
            .build();
    }

}
