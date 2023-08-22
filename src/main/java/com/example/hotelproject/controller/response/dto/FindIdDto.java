package com.example.hotelproject.controller.response.dto;

import com.example.hotelproject.domain.Hotel;
import com.example.hotelproject.domain.User;
import com.example.hotelproject.domain.room.Room;
import lombok.Builder;
import lombok.Data;

@Data
public class FindIdDto {
    private User user;
    private Hotel hotel;
    private Room room;

    @Builder
    public FindIdDto(User user, Hotel hotel, Room room) {
        this.user = user;
        this.hotel = hotel;
        this.room = room;
    }
}
