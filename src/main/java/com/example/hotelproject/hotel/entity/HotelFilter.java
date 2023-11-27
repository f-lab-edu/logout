package com.example.hotelproject.hotel.entity;

import com.example.hotelproject.hotel.controller.request.HotelSearchRequest;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class HotelFilter {

    private String hotelName;
    private String hotelType;
    private String location;
    private int grade;
    private Double starRateAverage;

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    private List<String> optionCode;

    @Builder
    public HotelFilter(String hotelName, String hotelType, String location, int grade,
            Double starRateAverage, LocalDateTime startDate, LocalDateTime endDate,
            List<String> optionCode) {
        this.hotelName = hotelName;
        this.hotelType = hotelType;
        this.location = location;
        this.grade = grade;
        this.starRateAverage = starRateAverage;
        this.startDate = startDate;
        this.endDate = endDate;
        this.optionCode = optionCode;
    }

    public HotelFilter of(HotelSearchRequest request) {
        return HotelFilter.builder()
                .hotelName(request.getHotelName())
                .hotelType(request.getHotelType())
                .location(request.getLocation())
                .grade(request.getGrade())
                .starRateAverage(request.getStarRateAverage())
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .build();
    }
}
