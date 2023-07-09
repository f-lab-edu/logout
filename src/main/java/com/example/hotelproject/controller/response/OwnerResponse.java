package com.example.hotelproject.controller.response;

import com.example.hotelproject.domain.Owner;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
public class OwnerResponse {
    private int userNo;
    private String userId;
    private String name;
    private int hotelNo;
    private String hotelName;

    @Builder
    public OwnerResponse(int userNo, String userId
                        , String name
                        , int hotelNo
                        , String hotelName) {
        this.userNo = userNo;
        this.userId = userId;
        this.name = name;
        this.hotelNo = hotelNo;
        this.hotelName = hotelName;
    }


    public static OwnerResponse of(Owner owner){
        return OwnerResponse.builder()
                .userNo(owner.getUserNo())
                .userId(owner.getUserId())
                .name(owner.getName())
                .hotelNo(owner.getHotelNo())
                .build();
    }

}
