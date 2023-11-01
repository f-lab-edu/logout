package com.example.hotelproject.hotel.entity;

public enum HotelTypeEnum {
    HOTEL("hotel"),
    RESORT("resort"),
    MOTEL("motel");

    private final String value;

    HotelTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
