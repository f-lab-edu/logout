package com.example.hotelproject.room.repository;

import com.example.hotelproject.room.entity.RoomQuantity;
import java.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomQuantityRepository extends JpaRepository<RoomQuantity, Long> {

    boolean existsByRoom_roomNoAndDate(Long roomNo, LocalDate date);

    RoomQuantity findByRoom_roomNoAndDate(Long roomNo, LocalDate date);

}
