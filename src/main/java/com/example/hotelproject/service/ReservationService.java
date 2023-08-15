package com.example.hotelproject.service;

import com.example.hotelproject.controller.request.reservation.ReservationCreateRequest;
import com.example.hotelproject.controller.response.ReservationDetailResponse;
import com.example.hotelproject.domain.Reservation;
import com.example.hotelproject.repository.HotelRepository;
import com.example.hotelproject.repository.ReservationRepository;
import com.example.hotelproject.repository.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservationService {

    private ReservationRepository reservationRepository;
    private UserRepository userRepository;
    private HotelRepository hotelRepository;

    public ReservationService(
        ReservationRepository reservationRepository,
        UserRepository userRepository,
        HotelRepository hotelRepository) {
        this.reservationRepository = reservationRepository;
        this.userRepository = userRepository;
        this.hotelRepository = hotelRepository;
    }

    @Transactional
    public Long create(ReservationCreateRequest request){
        Reservation reservation = request.toReservation();
        return reservationRepository.save(reservation).getId();
    }

    @Transactional(readOnly = true)
    public List<ReservationDetailResponse> findAllByUserNo(Long userNo) {
        return reservationRepository.findAllByUserNo(userNo).stream()
            .map(ReservationDetailResponse::of)
            .collect(Collectors.toList());
    }

    @Transactional
    public void cancel(Long id) {
        reservationRepository.deleteById(id);
    }
}
