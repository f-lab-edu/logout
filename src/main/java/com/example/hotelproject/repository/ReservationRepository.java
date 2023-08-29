package com.example.hotelproject.repository;

import com.example.hotelproject.domain.Reservation;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {

    Reservation save(Reservation request);

    List<Reservation> findAllByUser_UserNoAndCancelDateIsNull(Long userNo);

    List<Reservation> findByHotel_HotelNoAndRoom_RoomNo(Long hotelNo, Long RoomNo);

    Optional<Reservation> findById(Long reservationId);
}
