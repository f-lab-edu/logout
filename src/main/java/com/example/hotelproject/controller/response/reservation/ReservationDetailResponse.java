package com.example.hotelproject.controller.response.reservation;

import com.example.hotelproject.domain.Reservation;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReservationDetailResponse {
    private String userId;
    private Long hotelNo;
    private String hotelName;
    private LocalDate reservationStartDate;
    private LocalDate reservationEndDate;
    private LocalDateTime createdAt;

    @Builder
    public ReservationDetailResponse(String userId, Long hotelNo, String hotelName,
        LocalDate reservationStartDate, LocalDate reservationEndDate, LocalDateTime createdAt) {
        this.userId = userId;
        this.hotelNo = hotelNo;
        this.hotelName = hotelName;
        this.reservationStartDate = reservationStartDate;
        this.reservationEndDate = reservationEndDate;
        this.createdAt = createdAt;
    }


    public static ReservationDetailResponse of(Reservation reservation){
        return ReservationDetailResponse.builder()
            .hotelNo(reservation.getHotel().getHotelNo())
            .reservationStartDate(reservation.getReservationStartDate())
            .reservationEndDate(reservation.getReservationEndDate())
            .userId(reservation.getUser().getUserId())
            .hotelName(reservation.getHotel().getHotelName())
            .build();
    }
}
