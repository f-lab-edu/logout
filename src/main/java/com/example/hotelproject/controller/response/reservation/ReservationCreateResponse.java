package com.example.hotelproject.controller.response.reservation;

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
