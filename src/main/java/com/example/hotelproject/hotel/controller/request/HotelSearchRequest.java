package com.example.hotelproject.hotel.controller.request;

import com.example.hotelproject.hotel.entity.Hotel;
import com.example.hotelproject.hotel.entity.HotelOption;
import com.example.hotelproject.hotel.entity.HotelTypeEnum;
import java.time.LocalDateTime;
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

    private Double starRateAverage;

    private LocalDateTime startDate;
    private LocalDateTime endDate;


    @Builder
    public HotelSearchRequest(String hotelName, String hotelType, String location,
            List<HotelOption> options, String checkin, String checkout, int grade,
            Double starRateAverage, LocalDateTime startDate, LocalDateTime endDate) {
        this.hotelName = hotelName;
        this.hotelType = hotelType;
        this.location = location;
        this.options = options;
        this.checkin = checkin;
        this.checkout = checkout;
        this.grade = grade;
        this.starRateAverage = starRateAverage;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Hotel toEntity() {
        return Hotel.builder()
                .hotelName(hotelName)
                .hotelType(HotelTypeEnum.valueOf(hotelType))
                .location(location)
                .checkin(checkin)
                .checkout(checkout)
//                .options(options.toString())
                .build();
    }
}
