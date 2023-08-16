package com.example.hotelproject.service;

import com.example.hotelproject.controller.request.reservation.ReservationCreateRequest;
import com.example.hotelproject.controller.response.ReservationDetailResponse;
import com.example.hotelproject.domain.Reservation;
import com.example.hotelproject.domain.Room;
import com.example.hotelproject.repository.HotelRepository;
import com.example.hotelproject.repository.ReservationRepository;
import com.example.hotelproject.repository.UserRepository;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
        //중복예약 체크
//        List<Reservation> reservationList = reservationRepository.findReservationsByHotelAndRoom(
//            reservation.getHotel().getId(), reservation.getRoom().getRoomNo(),
//            reservation.getReservationStartDate(), reservation.getReservationEndDate());
//        if(reservationList.size() > 0){
//           throw new IllegalArgumentException("이미 에약한 사람이 있습니다.");
//        }

//        Reservation reservation = Reservation.builder()
//            .userNo(request.getUserNo())
//            .hotelNo(request.getHotelNo())
//            .roomNo(request.getRoomNo())
//            .reservationDate(request.getReservationDate())
//            .reservationStartDate(LocalDate.now().minusDays(1))
//            .reservationEndDate(LocalDate.now())
//            .build();

//        List<Reservation> list = reservationRepository.findByHotelNoAndRoomNoAndDate(
//            reservation.getHotelNo(), reservation.getRoomNo()
//            ,reservation.getReservationStartDate(), reservation.getReservationEndDate()
//        );
//        System.out.println(list);

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
