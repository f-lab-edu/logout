package com.example.hotelproject.hotel.controller.request;

import com.example.hotelproject.hotel.entity.AdditionalInfoEnum;
import com.example.hotelproject.hotel.entity.Hotel;
import com.example.hotelproject.hotel.entity.HotelTypeEnum;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class HotelUpdateRequest {

    /*호텔이름*/
    private String hotelName;
    /*호텔타입*/
    private String hotelType;
    /*위치*/
    private String location;
    private List<AdditionalInfoEnum> additionalInfo;
    private String checkin;
    private String checkout;
    private int grade;
    private String options;

    @Builder
    public HotelUpdateRequest(String hotelName, String hotelType, String location,
            String options, String checkin, String checkout, int grade) {
        this.hotelName = hotelName;
        this.hotelType = hotelType;
        this.location = location;
        this.options = options;
        this.checkin = checkin;
        this.checkout = checkout;
        this.grade = grade;
    }

    public Hotel toEntity() {
        return Hotel.builder()
                .hotelName(hotelName)
                .hotelType(HotelTypeEnum.valueOf(hotelType))
                .location(location)
                .checkin(checkin)
                .checkout(checkout)
                .build();
    }
}
