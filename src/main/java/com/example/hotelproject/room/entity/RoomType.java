package com.example.hotelproject.room.entity;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RoomType {

    SINGLE,
    DOUBLE,
    TWIN,
    TRIPLE,
    SUITE;

}
