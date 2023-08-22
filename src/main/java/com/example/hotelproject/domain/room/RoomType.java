package com.example.hotelproject.domain.room;


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
