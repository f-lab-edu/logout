package com.example.hotelproject.owner.controller.request;


import com.example.hotelproject.owner.entity.Owner;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor
public class OwnerCreateRequest {
    private Long ownerNo;
    private String name;
    private String ownerId;
    private String password;
    private String email;
    private String mobile;
    private String address;

    @Builder
    public OwnerCreateRequest(Long userNo, String name, String userId, String password,
        String email, String mobile, String address) {
        this.ownerNo = userNo;
        this.name = name;
        this.ownerId = userId;
        this.password = password;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
    }

    public Owner toEntity(){
        return Owner.builder()
            .ownerId(ownerId)
            .ownerNo(ownerNo)
            .password(password)
            .email(email)
            .name(name)
            .address(address)
            .mobile(mobile)
            .build();
    }

}
