package com.example.hotelproject.controller.response;

import com.example.hotelproject.domain.Reservation;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReservationDetailResponse {
    private Long userNo;
    private String userId;
    private Long hotelNo;
    private String hotelName;
    private Date reservationStartDate;
    private Date reservationEndDate;
    private LocalDateTime reservationDate;

    @Builder
    public ReservationDetailResponse(Long userNo, String userId, Long hotelNo, String hotelName,
        Date reservationStartDate, Date reservationEndDate, LocalDateTime reservationDate) {
        this.userNo = userNo;
        this.userId = userId;
        this.hotelNo = hotelNo;
        this.hotelName = hotelName;
        this.reservationStartDate = reservationStartDate;
        this.reservationEndDate = reservationEndDate;
        this.reservationDate = reservationDate;
    }


    public static ReservationDetailResponse of(Reservation reservation){
        return ReservationDetailResponse.builder()
            .userNo(reservation.getUserNo())
            .hotelNo(reservation.getHotelNo())
            .reservationDate(reservation.getReservationDate())
            .reservationStartDate(reservation.getReservationStartDate())
            .reservationEndDate(reservation.getReservationEndDate())
            .userId(reservation.getUser().getUserId())
            .hotelName(reservation.getHotel().getHotelName())
            .build();
    }
}
