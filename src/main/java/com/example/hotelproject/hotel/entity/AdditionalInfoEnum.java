package com.example.hotelproject.hotel.entity;

public enum AdditionalInfoEnum {
    BREAKFAST("breakfast"),
    PARKING("parking"),
    SWIMMING_POOL("swimming_pool"),
    FITNESS_CENTER("fitness_center");

    private final String value;

    AdditionalInfoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
