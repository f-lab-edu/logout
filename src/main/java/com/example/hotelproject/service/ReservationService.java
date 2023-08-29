package com.example.hotelproject.service;

import com.example.hotelproject.controller.request.reservation.ReservationCancelRequest;
import com.example.hotelproject.controller.request.reservation.ReservationCreateRequest;
import com.example.hotelproject.controller.response.dto.FindIdDto;
import com.example.hotelproject.controller.response.reservation.ReservationDetailResponse;
import com.example.hotelproject.domain.Hotel;
import com.example.hotelproject.domain.Reservation;
import com.example.hotelproject.domain.User;
import com.example.hotelproject.domain.room.Room;
import com.example.hotelproject.repository.HotelRepository;
import com.example.hotelproject.repository.ReservationRepository;
import com.example.hotelproject.repository.RoomRepository;
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
    private RoomRepository roomRepository;

    public ReservationService(
        ReservationRepository reservationRepository,
        UserRepository userRepository,
        HotelRepository hotelRepository,
        RoomRepository roomRepository) {
        this.reservationRepository = reservationRepository;
        this.userRepository = userRepository;
        this.hotelRepository = hotelRepository;
        this.roomRepository = roomRepository;
    }

    @Transactional
    public Long create(ReservationCreateRequest request) {
        FindIdDto validateFindIdDto = validateFindIdDto(request.getUser().getUserNo()
            , request.getHotel().getHotelNo(), request.getRoom().getRoomNo());

        Reservation reservation = request.toReservation(
            validateFindIdDto.getUser(),
            validateFindIdDto.getHotel(),
            validateFindIdDto.getRoom()
        );

        //중복예약 체크
        //호텔과 방이 중복되는지 체크
        List<Reservation> duplicatedRooms = reservationRepository.findByHotel_HotelNoAndRoom_RoomNo(
            reservation.getHotel().getHotelNo(), reservation.getRoom().getRoomNo());

        if(duplicatedRooms.isEmpty()){
            return reservationRepository.save(reservation).getId();
        }

        boolean isDuplicated = duplicatedRooms.stream().anyMatch(duplicatedDate
            -> duplicatedDate.isDuplicatedDate(reservation.getReservationStartDate(), reservation.getReservationEndDate()));

        if(isDuplicated){
            throw new IllegalArgumentException("duplicated");
        }else {
            return reservationRepository.save(reservation).getId();
        }

    }

    private FindIdDto validateFindIdDto(Long userNo, Long hotelNo, Long roomNo) {
        User user = userRepository.findUserByUserNo(userNo)
            .orElseThrow(() -> new IllegalArgumentException("no user"));
        Hotel hotel = hotelRepository.findByHotelNo(hotelNo)
            .orElseThrow(() -> new IllegalArgumentException("no hotel"));
        Room room = roomRepository.findByRoomNo(roomNo)
            .orElseThrow(() -> new IllegalArgumentException("no room"));

        return FindIdDto.builder()
            .user(user)
            .hotel(hotel)
            .room(room)
            .build();

    }

    @Transactional(readOnly = true)
    public List<ReservationDetailResponse> findAllByUserNo(Long userNo) {
        return reservationRepository.findAllByUser_UserNoAndCancelDateIsNull(userNo).stream()
            .map(ReservationDetailResponse::of).collect(Collectors.toList());
    }

    @Transactional
    public void cancel(ReservationCancelRequest request) {
        //reservationRepository.deleteById(id);
        FindIdDto validateFindIdDto = validateFindIdDto(request.getUser().getUserNo()
            , request.getHotel().getHotelNo(), request.getRoom().getRoomNo());

        Reservation reservation = request.toReservation(
            validateFindIdDto.getUser(),
            validateFindIdDto.getHotel(),
            validateFindIdDto.getRoom()
        );

        Reservation cancelItem = reservationRepository.findById(reservation.getId())
            .orElseThrow(()-> new IllegalArgumentException("예약된 내역이 없습니다"));

        cancelItem.updateCancelDate();
    }

    public List<ReservationDetailResponse> findAll() {
        return reservationRepository.findAll()
                .stream()
                .map(ReservationDetailResponse::of)
                .collect(Collectors.toList());
    }
}
