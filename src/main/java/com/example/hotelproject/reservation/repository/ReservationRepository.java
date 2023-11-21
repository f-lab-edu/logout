package com.example.hotelproject.reservation.repository;

import com.example.hotelproject.reservation.entity.Reservation;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    Reservation save(Reservation request);

    List<Reservation> findAllByMember_MemberIdAndCancelDateIsNull(Long userNo);

    List<Reservation> findByHotel_HotelNoAndRoom_RoomNo(Long hotelNo, Long RoomNo);

    Optional<Reservation> findById(Long reservationId);
}
