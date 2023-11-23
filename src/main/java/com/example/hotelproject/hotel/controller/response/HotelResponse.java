package com.example.hotelproject.hotel.controller.response;

import com.example.hotelproject.hotel.entity.Hotel;
import com.example.hotelproject.hotel.entity.HotelOption;
import java.util.List;
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
    private List<HotelOption> options;
    private String checkin;
    private String checkout;
    private String remrk;
    private Double starRateAverage;

    @Builder
    public HotelResponse(String hotelName, String hotelType, String location,
            int grade,
            List<HotelOption> options, String checkin, String checkout,
            String remrk, double starRateAverage) {
        this.hotelName = hotelName;
        this.hotelType = hotelType;
        this.location = location;
        this.grade = grade;
        this.options = options;
        this.checkin = checkin;
        this.checkout = checkout;
        this.remrk = remrk;
        this.starRateAverage = starRateAverage;
    }

    public static HotelResponse of(Hotel hotel) {
        return HotelResponse.builder()
                .hotelName(hotel.getHotelName())
                .hotelType(hotel.getHotelType().name())
                .location(hotel.getLocation())
                .grade(hotel.getGrade())
                .checkin(hotel.getCheckin())
                .checkout(hotel.getCheckout())
                .starRateAverage(hotel.getStarRateAverage())
                .build();
    }

}
