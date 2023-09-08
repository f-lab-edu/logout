package com.example.hotelproject.room.entity;

import com.example.hotelproject.hotel.entity.Hotel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.hotelproject.util.entity.BaseDateTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) //기본 생성자를 만들어줌
@ToString
@Entity(name = "room")
public class Room extends BaseDateTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_no")
    private Long roomNo;

    @Column(name = "price")
    private int price;

    @Column(name = "basic_occupancy")
    private int basicOccupancy;

    @Column(name = "maximum_occupancy")
    private int maximumOccupancy;

    @Enumerated(EnumType.STRING)
    @Column(name = "room_type")
    private RoomType roomType;

    @Enumerated(EnumType.STRING)
    @Column(name = "room_level")
    private RoomLevel roomLevel;

    @Column(name = "smoking_yn")
    private Boolean smokingYn;

    @Column(name = "remrk")
    private String remrk;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_no")
    private Hotel hotel;

    @Builder
    public Room(int price, int basicOccupancy, int maximumOccupancy,
        RoomType roomType, RoomLevel roomLevel, Boolean smokingYn, String remrk,
        Hotel hotel) {
        this.price = price;
        this.basicOccupancy = basicOccupancy;
        this.maximumOccupancy = maximumOccupancy;
        this.roomType = roomType;
        this.roomLevel = roomLevel;
        this.smokingYn = smokingYn;
        this.remrk = remrk;
        this.hotel = hotel;
    }
}
