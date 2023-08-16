package com.example.hotelproject.controller.request.reservation;

import com.example.hotelproject.domain.Reservation;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class ReservationCreateRequest {

    private Long userNo;
    private Long hotelNo;
    private Long roomNo;
    private LocalDate reservationStartDate;
    private LocalDate reservationEndDate;
    private LocalDateTime reservationDate;


    @Builder
    public ReservationCreateRequest(Long userNo, Long hotelNo, Long roomNo,
        LocalDate reservationStartDate, LocalDate reservationEndDate, LocalDateTime reservationDate) {
        this.userNo = userNo;
        this.hotelNo = hotelNo;
        this.roomNo = roomNo;
        this.reservationStartDate = reservationStartDate;
        this.reservationEndDate = reservationEndDate;
        this.reservationDate = reservationDate;
    }

    public Reservation toReservation(){
        return Reservation.builder()
            .userNo(userNo)
            .hotelNo(hotelNo)
            .roomNo(roomNo)
            .reservationDate(LocalDateTime.now())
            .reservationStartDate(reservationStartDate)
            .reservationEndDate(reservationEndDate)
            .build();
    }
}
