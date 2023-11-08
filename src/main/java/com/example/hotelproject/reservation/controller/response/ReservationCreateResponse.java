package com.example.hotelproject.reservation.controller.response;

import com.example.hotelproject.reservation.entity.Reservation;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class ReservationCreateResponse {

    private String email;
    private Long hotelNo;
    private Long RoomNo;
    private LocalDate reservationStartDate;
    private LocalDate reservationEndDate;
    private LocalDateTime createdAt;

    @Builder
    public ReservationCreateResponse(String email, Long hotelNo, Long roomNo,
            LocalDate reservationStartDate, LocalDate reservationEndDate, LocalDateTime createdAt) {
        this.email = email;
        this.hotelNo = hotelNo;
        RoomNo = roomNo;
        this.reservationStartDate = reservationStartDate;
        this.reservationEndDate = reservationEndDate;
        this.createdAt = createdAt;
    }

    public ReservationCreateResponse of(Reservation reservation) {
        return ReservationCreateResponse.builder()
                .email(reservation.getMember().getEmail())
                .hotelNo(reservation.getHotel().getHotelNo())
                .roomNo(reservation.getRoom().getRoomNo())
                .createdAt(createdAt)
                .reservationStartDate(reservationStartDate)
                .reservationEndDate(reservationEndDate)
                .build();
    }
}
