package com.example.hotelproject.reservation.controller.request;

import com.example.hotelproject.hotel.entity.Hotel;
import com.example.hotelproject.member.entity.Member;
import com.example.hotelproject.reservation.entity.Reservation;
import com.example.hotelproject.room.entity.Room;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class ReservationCancelRequest {

    private Long reservationId;
    private String email;
    private Long hotelNo;
    private Long roomNo;
    private LocalDateTime reservationStartDate;
    private LocalDateTime reservationEndDate;

    @Builder
    public ReservationCancelRequest(Long reservationId, String email, Long hotelNo, Long roomNo,
            LocalDateTime reservationStartDate, LocalDateTime reservationEndDate) {
        this.reservationId = reservationId;
        this.email = email;
        this.hotelNo = hotelNo;
        this.roomNo = roomNo;
        this.reservationStartDate = reservationStartDate;
        this.reservationEndDate = reservationEndDate;
    }


    public Reservation toReservation(Member member, Hotel hotel, Room room) {
        return Reservation.builder()
                .reservationId(reservationId)
                .member(member)
                .hotel(hotel)
                .room(room)
                .reservationStartDate(reservationStartDate)
                .reservationEndDate(reservationEndDate)
                .build();
    }
}
