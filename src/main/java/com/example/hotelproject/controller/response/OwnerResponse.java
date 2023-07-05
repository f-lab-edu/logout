package com.example.hotelproject.controller.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
public class OwnerResponse {
    private String userId;
    private String name;
    private String hotelNo;
    private String hotelNm;

    @Builder
    public OwnerResponse(String userId
                        , String name
                        , String hotelNo
                        , String hotelNm) {
        this.userId = userId;
        this.name = name;
        this.hotelNo = hotelNo;
        this.hotelNm = hotelNm;
    }

    protected OwnerResponse() {
    }

}
