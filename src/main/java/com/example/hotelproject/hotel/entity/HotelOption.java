package com.example.hotelproject.hotel.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "hotel_option")
public class HotelOption {

    @Id
    @Column(name = "code")
    private String code;

    @Column(name = "description")
    private String description;

    @Builder
    public HotelOption(String code, String description) {
        this.code = code;
        this.description = description;
    }
}
