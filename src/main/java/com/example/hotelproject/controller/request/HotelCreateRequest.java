package com.example.hotelproject.controller.request;

import com.example.hotelproject.domain.Hotel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class HotelCreateRequest {
    /*호텔이름*/
    private String hotelName;
    /*호텔타입*/
    private String hotelType;
    /*위치*/
    private String location;
    /*호텔등급*/
    private int grade;
    /*조식제공여부*/
    private boolean breakfastYn;
    /*주차가능여부*/
    private boolean parkingYn;
    /*수영장여부*/
    private boolean swimYn;
    /*휘트니스 여부*/
    private boolean fitnessYn;
    private String checkin;
    private String checkout;
    private String remrk;

    @Builder
    public HotelCreateRequest( String hotelName, String hotelType, String location, int grade, boolean breakfastYn, boolean parkingYn, boolean swimYn, boolean fitnessYn, String checkin, String checkout, String remrk) {
        this.hotelName = hotelName;
        this.hotelType = hotelType;
        this.location = location;
        this.grade = grade;
        this.breakfastYn = breakfastYn;
        this.parkingYn = parkingYn;
        this.swimYn = swimYn;
        this.fitnessYn = fitnessYn;
        this.checkin = checkin;
        this.checkout = checkout;
        this.remrk = remrk;
    }

    public Hotel toEntity(){
        return Hotel.builder()
            .hotelName(hotelName)
            .hotelType(hotelType)
            .location(location)
            .grade(grade)
            .breakfastYn(breakfastYn)
            .parkingYn(parkingYn)
            .swimYn(swimYn)
            .fitnessYn(fitnessYn)
            .checkin(checkin)
            .checkout(checkout)
            .remrk(remrk)
            .build();
    }
}
