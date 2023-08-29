package com.example.hotelproject.controller.response.owner;

import com.example.hotelproject.domain.Owner;
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
                .userId(owner.getUserId())
                .build();
    }

}
