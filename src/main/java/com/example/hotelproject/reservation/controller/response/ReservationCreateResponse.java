package com.example.hotelproject.reservation.controller.response;

import com.example.hotelproject.hotel.entity.Hotel;
import com.example.hotelproject.reservation.entity.Reservation;
import com.example.hotelproject.user.entity.User;
import com.example.hotelproject.room.entity.Room;
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

    private User user;
    private Hotel hotel;
    private Room room;
    private LocalDate reservationStartDate;
    private LocalDate reservationEndDate;
    private LocalDateTime createdAt;

    @Builder
    public ReservationCreateResponse(User user, Hotel hotel,
        Room room, LocalDate reservationStartDate, LocalDate reservationEndDate,
        LocalDateTime createdAt) {
        this.user = user;
        this.hotel = hotel;
        this.room = room;
        this.reservationStartDate = reservationStartDate;
        this.reservationEndDate = reservationEndDate;
        this.createdAt = createdAt;
    }
    public ReservationCreateResponse of(Reservation reservation){
        return ReservationCreateResponse.builder()
            .user(user)
            .hotel(hotel)
            .room(room)
            .createdAt(createdAt)
            .reservationStartDate(reservationStartDate)
            .reservationEndDate(reservationEndDate)
            .build();
    }
}
