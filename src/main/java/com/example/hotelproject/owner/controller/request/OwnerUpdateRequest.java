package com.example.hotelproject.owner.controller.request;


import com.example.hotelproject.owner.entity.Owner;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor
public class OwnerUpdateRequest {
    private Long ownerNo;
    private String name;
    private String ownerId;
    private String password;
    private String email;
    private String mobile;
    private String address;

    @Builder
    public OwnerUpdateRequest(Long ownerNo, String name, String ownerId, String password,
        String email, String mobile, String address) {
        this.ownerNo = ownerNo;
        this.name = name;
        this.ownerId = ownerId;
        this.password = password;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
    }

    public Owner toOwner(){
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
