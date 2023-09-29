package com.example.hotelproject.owner.controller.response;

import com.example.hotelproject.hotel.entity.Hotel;
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
            String checkin, String checkout, String remrk, int owner_no) {
        this.hotelName = hotelName;
        this.hotelType = hotelType;
        this.location = location;
        this.grade = grade;

        this.checkin = checkin;
        this.checkout = checkout;
        this.remrk = remrk;
        this.owner_no = owner_no;
    }

    public static OwnersHotelsResponse of(Hotel hotel) {
        return OwnersHotelsResponse.builder()
                .hotelName(hotel.getHotelName())
                .hotelType(hotel.getHotelType())
                .location(hotel.getLocation())
                .grade(hotel.getGrade())
                .checkin(hotel.getCheckin())
                .checkout(hotel.getCheckout())
                .build();
    }
}
