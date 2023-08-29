package com.example.hotelproject.repository;

import com.example.hotelproject.domain.Hotel;
import com.example.hotelproject.domain.room.Room;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room,Long> {

    Room save(Room room);

    List<Room> findAll();

    void deleteByRoomNo(@Param("roomNo") Long roomNo);

    Optional<Room> findByRoomNo(@Param("roomNo") Long roomNo);
}
