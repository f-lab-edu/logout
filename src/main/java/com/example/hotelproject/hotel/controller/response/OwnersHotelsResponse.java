package com.example.hotelproject.hotel.controller.response;

import com.example.hotelproject.hotel.entity.Hotel;
import com.example.hotelproject.hotel.entity.HotelOption;
import com.example.hotelproject.hotel.entity.HotelTypeEnum;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OwnersHotelsResponse {

    private String hotelName;
    private HotelTypeEnum hotelType;
    private String location;
    private int grade;
    private String checkin;
    private String checkout;
    private List<HotelOption> options;
    private Double starRateAverage;

    @Builder
    public OwnersHotelsResponse(String hotelName, HotelTypeEnum hotelType, String location,
            int grade,
            String checkin, String checkout, List<HotelOption> options, double starRateAverage) {
        this.hotelName = hotelName;
        this.hotelType = hotelType;
        this.location = location;
        this.grade = grade;
        this.checkin = checkin;
        this.checkout = checkout;
        this.options = options;
        this.starRateAverage = starRateAverage;
    }

    public static OwnersHotelsResponse of(Hotel hotel) {
        return OwnersHotelsResponse.builder()
                .hotelName(hotel.getHotelName())
                .hotelType(hotel.getHotelType())
                .location(hotel.getLocation())
                .grade(hotel.getGrade())
                .checkin(hotel.getCheckin())
                .checkout(hotel.getCheckout())
                .starRateAverage(hotel.getStarRateAverage())
                .build();
    }
}
