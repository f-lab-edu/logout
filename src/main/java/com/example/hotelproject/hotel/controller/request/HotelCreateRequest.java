package com.example.hotelproject.hotel.controller.request;

import com.example.hotelproject.hotel.entity.Hotel;
import com.example.hotelproject.hotel.entity.HotelTypeEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class HotelCreateRequest {

    @ApiModelProperty(value = "호텔이름")
    private String hotelName;

    @ApiModelProperty(value = "호텔타입", example = "리조트")
    private String hotelType;

    @ApiModelProperty(value = "위치", example = "서울")
    private String location;
    @ApiModelProperty(value = "등급")
    private int grade;

    @ApiModelProperty(value = "체크인시간")
    private String checkin;

    @ApiModelProperty(value = "체크아웃시간")
    private String checkout;

    @ApiModelProperty(value = "옵션")
    private String options;

    @Builder
    public HotelCreateRequest(String hotelName, String hotelType, String location, int grade,
            String checkin, String checkout) {
        this.hotelName = hotelName;
        this.hotelType = hotelType;
        this.location = location;
        this.grade = grade;
//        this.options = options;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public Hotel toEntity() {
        return Hotel.builder()
                .hotelName(hotelName)
                .hotelType(HotelTypeEnum.valueOf(hotelType))
                .location(location)
                .grade(grade)
                .checkin(checkin)
                .checkout(checkout)
//                .options(options)
                .build();
    }
}
