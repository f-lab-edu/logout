package com.example.hotelproject.dto;

import com.example.hotelproject.hotel.entity.Hotel;
import com.example.hotelproject.user.entity.User;
import com.example.hotelproject.room.entity.Room;
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
