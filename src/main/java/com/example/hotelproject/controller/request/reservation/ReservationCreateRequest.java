package com.example.hotelproject.controller.request.reservation;

import com.example.hotelproject.domain.Reservation;
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
    private Date reservationStartDate;
    private Date reservationEndDate;
    private LocalDateTime reservationDate;

    @Builder
    public ReservationCreateRequest(Long userNo, Long hotelNo, Date reservationStartDate,
        Date reservationEndDate, LocalDateTime reservationDate) {
        this.userNo = userNo;
        this.hotelNo = hotelNo;
        this.reservationStartDate = reservationStartDate;
        this.reservationEndDate = reservationEndDate;
        this.reservationDate = reservationDate;
    }

    public Reservation toReservation(){
        return Reservation.builder()
            .userNo(userNo)
            .hotelNo(hotelNo)
            .reservationDate(LocalDateTime.now())
            .reservationStartDate(reservationStartDate)
            .reservationEndDate(reservationEndDate)
            .build();
    }
}
