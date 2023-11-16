package com.example.hotelproject.hotel.entity;

import com.example.hotelproject.hotel.controller.request.HotelSearchRequest;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class HotelFilter {

    private String hotelName;
    private HotelTypeEnum hotelType;
    private String location;
    private int grade;
    private String option;
    private Double starRateAverage;

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    @Builder
    public HotelFilter(String hotelName, HotelTypeEnum hotelType, String location, int grade,
            String option, Double starRateAverage, LocalDateTime startDate, LocalDateTime endDate) {
        this.hotelName = hotelName;
        this.hotelType = hotelType;
        this.location = location;
        this.grade = grade;
        this.option = option;
        this.starRateAverage = starRateAverage;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public HotelFilter of(HotelSearchRequest request) {
        return HotelFilter.builder()
                .hotelName(request.getHotelName())
                .hotelType(HotelTypeEnum.valueOf(request.getHotelType()))
                .location(request.getLocation())
                .option(request.getOptions().toString())
                .grade(request.getGrade())
                .starRateAverage(request.getStarRateAverage())
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .build();
    }
}
