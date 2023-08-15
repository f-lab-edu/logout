package com.example.hotelproject.repository;

import com.example.hotelproject.domain.Reservation;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {

    Reservation save(Reservation request);

    Optional<Reservation> findAllByUserNo(Long userNo);

}
