package com.example.hotelproject.hotel.controller.request;

import com.example.hotelproject.hotel.entity.Hotel;
import com.example.hotelproject.hotel.entity.HotelOption;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class HotelSearchRequest {

    private String hotelName;
    private String hotelType;
    private String location;
    private List<HotelOption> options;
    private String checkin;
    private String checkout;
    private int grade;

    @Builder
    public HotelSearchRequest(String hotelName, String hotelType, String location,
            List<HotelOption> options, String checkin, String checkout, int grade) {
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
                .hotelType(hotelType)
                .location(location)
                .checkin(checkin)
                .checkout(checkout)
                .options(options)
                .build();
    }
}
