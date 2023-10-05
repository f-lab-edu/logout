package com.example.hotelproject.dto;

import com.example.hotelproject.hotel.entity.Hotel;
import com.example.hotelproject.user.entity.User;
import com.example.hotelproject.room.entity.Room;
import lombok.Builder;
import lombok.Data;

@Data
public class FindIdDto { // 이 클래스는 저번에 reservation id로 쓰기로 했던거죠 ?
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
