package com.example.hotelproject.hotel.entity;


//TODO: 삭제예정
public enum HotelOptionEnum {

    BREAKFAST("breakfast"),
    SWIMMING_POOL("swimming_pool"),
    PARKING("parking"),
    FITNESS("fitness");

    private final String value;

    HotelOptionEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
