package com.example.hotelproject.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED) //기본 생성자를 만들어줌
@ToString
@Entity(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_no")
    private Long roomNo;

    @Column(name = "hotel_no")
    private Long hotelNo;

    @Column(name = "price")
    private int price;

    @Column(name = "basic_occupancy")
    private int basicOccupancy;

    @Column(name = "maximum_occupancy")
    private int maximumOccupancy;

    @Column(name = "room_type")
    private String roomType;

    @Column(name = "bed_type")
    private String bedType;

    @Column(name = "smoking_yn")
    private Boolean smokingYn;

    @Column(name = "remrk")
    private String remrk;

    @ManyToOne
    @JoinColumn(name = "hotel_no", insertable = false, updatable = false)
    private Hotel hotel;

    public Room(Long roomNo, Long hotelNo, int price, int basicOccupancy, int maximumOccupancy,
        String roomType, String bedType, Boolean smokingYn, String remrk,
        Hotel hotel) {
        this.roomNo = roomNo;
        this.hotelNo = hotelNo;
        this.price = price;
        this.basicOccupancy = basicOccupancy;
        this.maximumOccupancy = maximumOccupancy;
        this.roomType = roomType;
        this.bedType = bedType;
        this.smokingYn = smokingYn;
        this.remrk = remrk;
        this.hotel = hotel;
    }
}
