package com.example.hotelproject.reservation.controller.request;

import com.example.hotelproject.hotel.entity.Hotel;
import com.example.hotelproject.reservation.entity.Reservation;
import com.example.hotelproject.user.entity.User;
import com.example.hotelproject.room.entity.Room;
import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class ReservationCancelRequest {

    private Long id;
    private User user;
    private Hotel hotel;
    private Room room;
    private LocalDate reservationStartDate;
    private LocalDate reservationEndDate;

    @Builder
    public ReservationCancelRequest(Long id, User user, Hotel hotel,
        Room room, LocalDate reservationStartDate, LocalDate reservationEndDate) {
        this.id = id;
        this.user = user;
        this.hotel = hotel;
        this.room = room;
        this.reservationStartDate = reservationStartDate;
        this.reservationEndDate = reservationEndDate;
    }

    public Reservation toReservation(User user, Hotel hotel, Room room){
        return Reservation.builder()
            .id(id)
            .user(user)
            .hotel(hotel)
            .room(room)
            .reservationStartDate(reservationStartDate)
            .reservationEndDate(reservationEndDate)
            .build();
    }
}
