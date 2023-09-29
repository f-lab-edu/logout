package com.example.hotelproject.reservation.service;

import com.example.hotelproject.dto.FindIdDto;
import com.example.hotelproject.hotel.entity.Hotel;
import com.example.hotelproject.hotel.repository.HotelRepository;
import com.example.hotelproject.reservation.controller.request.ReservationCancelRequest;
import com.example.hotelproject.reservation.controller.request.ReservationCreateRequest;
import com.example.hotelproject.reservation.controller.response.ReservationDetailResponse;
import com.example.hotelproject.reservation.entity.Reservation;
import com.example.hotelproject.reservation.repository.ReservationRepository;
import com.example.hotelproject.room.entity.Room;
import com.example.hotelproject.room.repository.RoomRepository;
import com.example.hotelproject.user.entity.User;
import com.example.hotelproject.user.repository.UserRepository;
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

        if (duplicatedRooms.isEmpty()) {
            return reservationRepository.save(reservation).getId();
        }

        boolean isDuplicated = duplicatedRooms.stream().anyMatch(duplicatedDate
                -> duplicatedDate.isDuplicatedDate(reservation.getReservationStartDate(),
                reservation.getReservationEndDate()));

        if (isDuplicated) {
            throw new IllegalArgumentException("duplicated");
        } else {
            return reservationRepository.save(reservation).getId();
        }

    }


    /////TODO: 수정필요!!!!!!
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

        FindIdDto validateFindIdDto = validateFindIdDto(request.getUser().getUserNo()
                , request.getHotel().getHotelNo(), request.getRoom().getRoomNo());

        Reservation reservation = request.toReservation(
                validateFindIdDto.getUser(),
                validateFindIdDto.getHotel(),
                validateFindIdDto.getRoom()
        );

        Reservation cancelItem = reservationRepository.findById(reservation.getId())
                .orElseThrow(() -> new IllegalArgumentException("예약된 내역이 없습니다"));

        cancelItem.updateCancelDate();
    }

    public List<ReservationDetailResponse> findAll() {
        return reservationRepository.findAll()
                .stream()
                .map(ReservationDetailResponse::of)
                .collect(Collectors.toList());
    }
}
