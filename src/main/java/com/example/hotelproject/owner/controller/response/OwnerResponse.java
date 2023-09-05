package com.example.hotelproject.owner.controller.response;

import com.example.hotelproject.owner.entity.Owner;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class OwnerResponse {
    private String userId;

    @Builder
    public OwnerResponse(String userId) {
        this.userId = userId;
    }

    public static OwnerResponse of(Owner owner){
        return OwnerResponse.builder()
                .userId(owner.getOwnerId())
                .build();
    }

}
