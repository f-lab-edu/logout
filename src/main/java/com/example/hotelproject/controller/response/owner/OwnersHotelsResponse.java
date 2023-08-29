package com.example.hotelproject.controller.response.owner;

import com.example.hotelproject.domain.Hotel;
import lombok.Builder;
import lombok.Getter;

@Getter
public class OwnersHotelsResponse {

    private String hotelName;
    private String hotelType;
    private String location;
    private int grade;
    private boolean breakfastYn;
    private boolean parkingYn;
    private boolean swimYn;
    private boolean fitnessYn;
    private String checkin;
    private String checkout;
    private String remrk;
    private int owner_no;

    @Builder
    public OwnersHotelsResponse(String hotelName, String hotelType, String location, int grade,
        boolean breakfastYn, boolean parkingYn, boolean swimYn, boolean fitnessYn,
        String checkin, String checkout, String remrk, int owner_no) {
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
        this.owner_no = owner_no;
    }

    public static OwnersHotelsResponse of(Hotel hotel){
        return OwnersHotelsResponse.builder()
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
