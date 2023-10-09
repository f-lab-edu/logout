package com.example.hotelproject.room.controller.request;

import com.example.hotelproject.hotel.entity.Hotel;
import com.example.hotelproject.room.entity.Room;
import com.example.hotelproject.room.entity.RoomQuantity;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class RoomCancelQuantityRequest {

    private Long hotelNo;
    private Long roomNo;
    private LocalDate date;

    private Integer nights; //숙박기간

    @Builder
    public RoomCancelQuantityRequest(Long hotelNo, Long roomNo, LocalDate date, Integer nights) {
        this.hotelNo = hotelNo;
        this.roomNo = roomNo;
        this.date = date;
        this.nights = nights;
    }

    public RoomQuantity toRoomQuantity(Hotel hotel, Room room) {
        return RoomQuantity.builder()
                .hotel(hotel)
                .room(room)
                .date(date)
                .build();
    }
}
