package com.example.hotelproject.controller.request.reservation;

import com.example.hotelproject.domain.Hotel;
import com.example.hotelproject.domain.Reservation;
import com.example.hotelproject.domain.User;
import com.example.hotelproject.domain.room.Room;
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

    private User user;
    private Hotel hotel;
    private Room room;
    private LocalDate reservationStartDate;
    private LocalDate reservationEndDate;

    @Builder
    public ReservationCreateRequest(User user, Hotel hotel,
        Room room, LocalDate reservationStartDate, LocalDate reservationEndDate) {
        this.user = user;
        this.hotel = hotel;
        this.room = room;
        this.reservationStartDate = reservationStartDate;
        this.reservationEndDate = reservationEndDate;
    }

    public Reservation toReservation(User user, Hotel hotel, Room room){
        return Reservation.builder()
            .user(user)
            .hotel(hotel)
            .room(room)
            .reservationStartDate(reservationStartDate)
            .reservationEndDate(reservationEndDate)
            .build();
    }
}
