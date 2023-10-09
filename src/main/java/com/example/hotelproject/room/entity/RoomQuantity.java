package com.example.hotelproject.room.entity;

import com.example.hotelproject.hotel.entity.Hotel;
import com.example.hotelproject.util.entity.BaseDateTimeEntity;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "room_quantity")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RoomQuantity extends BaseDateTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "quantity")
    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_no")
    private Room room;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_no")
    private Hotel hotel;

    @Builder
    public RoomQuantity(Long id, LocalDate date, Integer quantity, Room room, Hotel hotel) {
        this.id = id;
        this.date = date;
        this.quantity = quantity;
        this.room = room;
        this.hotel = hotel;
    }

    public void update(Integer quantity) {
        this.quantity = quantity;
    }
}
