package com.example.hotelproject.repository;

import com.example.hotelproject.domain.Reservation;
import com.example.hotelproject.domain.Room;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {

    Reservation save(Reservation request);

    Optional<Reservation> findAllByUserNo(Long userNo);

//    @Query("select r from reservation r where r.hotelNo = :hotelNo and r.roomNo = :roomNo"
//        + " or r.reservationStartDate = :sDate or r.reservationEndDate = :eDate")
//    List<Reservation> findByHotelNoAndRoomNoAndDate(
//        @Param("hotelNo") Long hotelNo,
//        @Param("roomNo") Long roomNo,
//        @Param("sDAte") LocalDate reservationStartDate,
//        @Param("eDate") LocalDate reservationEndDate);

}
