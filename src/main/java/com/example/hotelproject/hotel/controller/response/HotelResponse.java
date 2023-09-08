package com.example.hotelproject.hotel.controller.response;

import com.example.hotelproject.hotel.entity.Hotel;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class HotelResponse {
    private String hotelName;
    private String hotelType;
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
    public HotelResponse(String hotelName, String hotelType, String location,
        int grade,
        boolean breakfastYn, boolean parkingYn, boolean swimYn, boolean fitnessYn,
        String checkin, String checkout, String remrk) {
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

    public static HotelResponse of(Hotel hotel){
        return HotelResponse.builder()
            .hotelName(hotel.getHotelName())
            .hotelType(hotel.getHotelType())
            .location(hotel.getLocation())
            .grade(hotel.getGrade())
            .breakfastYn(hotel.isBreakfastYn())
            .parkingYn(hotel.isParkingYn())
            .swimYn(hotel.isSwimYn())
            .fitnessYn(hotel.isFitnessYn())
            .checkin(hotel.getCheckin())
            .checkout(hotel.getCheckout())
            .build();
    }

}
