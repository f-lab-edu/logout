package com.example.hotelproject.reservation.controller.response;

import com.example.hotelproject.reservation.entity.Reservation;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReservationDetailResponse {

    private String nickname;
    private String email;
    private Long hotelNo;
    private String hotelName;
    private LocalDateTime reservationStartDate;
    private LocalDateTime reservationEndDate;
    private LocalDateTime createdAt;


    @Builder
    public ReservationDetailResponse(String nickname, String email, Long hotelNo, String hotelName,
            LocalDateTime reservationStartDate, LocalDateTime reservationEndDate,
            LocalDateTime createdAt) {
        this.nickname = nickname;
        this.email = email;
        this.hotelNo = hotelNo;
        this.hotelName = hotelName;
        this.reservationStartDate = reservationStartDate;
        this.reservationEndDate = reservationEndDate;
        this.createdAt = createdAt;
    }

    public static ReservationDetailResponse of(Reservation reservation) {
        return ReservationDetailResponse.builder()
                .nickname(reservation.getMember().getNickname())
                .email(reservation.getMember().getEmail())
                .hotelNo(reservation.getHotel().getHotelNo())
                .reservationStartDate(reservation.getReservationStartDate())
                .reservationEndDate(reservation.getReservationEndDate())
                .hotelName(reservation.getHotel().getHotelName())
                .build();
    }
}
