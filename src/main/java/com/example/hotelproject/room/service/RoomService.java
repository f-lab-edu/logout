package com.example.hotelproject.room.service;

import com.example.hotelproject.hotel.repository.HotelRepository;
import com.example.hotelproject.room.repository.RoomRepository;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    private final HotelRepository hotelRepository;
    private final RoomRepository roomRepository;

    public RoomService(HotelRepository hotelRepository, RoomRepository roomRepository) {
        this.hotelRepository = hotelRepository;
        this.roomRepository = roomRepository;
    }

//
//    public void MaxQuantitySetting(RoomReservationQuantityRequest roomReservationQuantityRequest) {
//        Hotel hotel = hotelRepository.findByHotelNo(roomReservationQuantityRequest.getHotelNo())
//                .orElseThrow(() -> new EntityNotFoundException("hotel not found"));
//
//        Room room = roomRepository.findByRoomNo(roomReservationQuantityRequest.getRoomNo())
//                .orElseThrow(() -> new EntityNotFoundException("room not found"));
//
//        RoomQuantity quantity = roomReservationQuantityRequest.toRoomQuantity(hotel, room);
//
//        List<LocalDate> exist = new ArrayList<>();
//        List<LocalDate> notExist = new ArrayList<>();
//
//        //숙박기간 데이터 확인
//        if (roomReservationQuantityRequest.getNights() > 0) {
//            List<LocalDate> nights = new ArrayList<>();
//            for (int i = 0; i <= roomReservationQuantityRequest.getNights(); i++) {
//                LocalDate date = quantity.getDate().plusDays(i);
//                nights.add(date);
//            }
//
//            for (LocalDate night : nights) {
//                boolean isExistRow = roomQuantityRepository.existsByRoom_roomNoAndDate(
//                        quantity.getRoom().getRoomNo(), quantity.getDate());
//                if (isExistRow) { //데이터가 있는 날짜
//                    exist.add(night);
//                } else { //데이터가 없는 날짜
//                    notExist.add(night);
//                }
//            }
//        }
//
//        //존재하는 데이터는 update, 없는 데이터는 create
//        //update
//        if (!exist.isEmpty()) {
//            for (LocalDate updateDate : exist) {
//                RoomQuantity updateQuantity = roomQuantityRepository.findByRoom_roomNoAndDate(
//                        quantity.getRoom().getRoomNo(), updateDate);
//                //잔여수량 확인
//                if (updateQuantity.getQuantity() == 0) {
//                    throw new IllegalArgumentException(
//                            updateDate + " 날짜에" + updateQuantity.getRoom() + "의"
//                                    + "예약가능한 수량이 없습니다.");
//                }
//
//                //수량 업뎃
//                Integer settingDate = updateQuantity.getQuantity() - 1;
//                updateQuantity.update(settingDate);
//                //save 날려줘야하는지...
//            }
//        }
//
//        //create
//        if (!notExist.isEmpty()) {
//            for (LocalDate createDate : notExist) {
//                //max에서 -1
//                RoomQuantity createQuantity = RoomQuantity.builder()
//                        .room(quantity.getRoom())
//                        .hotel(quantity.getHotel())
//                        .quantity(room.getMaxQuantity() - 1)
//                        .date(createDate)
//                        .build();
//                roomQuantityRepository.save(createQuantity);
//            }
//        }
//
//    }
//
//    public void cancelQuantitySetting(RoomCancelQuantityRequest request) {
//        Hotel hotel = hotelRepository.findByHotelNo(request.getHotelNo())
//                .orElseThrow(() -> new EntityNotFoundException("hotel not found"));
//
//        Room room = roomRepository.findByRoomNo(request.getRoomNo())
//                .orElseThrow(() -> new EntityNotFoundException("room not found"));
//
//        RoomQuantity quantity = request.toRoomQuantity(hotel, room);
//
//        List<LocalDate> nights = new ArrayList<>();
//
//        for (int i = 0; i <= request.getNights(); i++) {
//            LocalDate date = quantity.getDate().plusDays(i);
//            RoomQuantity updateQuantity = roomQuantityRepository.findByRoom_roomNoAndDate(
//                    quantity.getRoom().getRoomNo(), date);
//            Integer settingDate = updateQuantity.getQuantity() + 1;
//            updateQuantity.update(settingDate);//TODO:테스트필요
//        }
//
//    }
//
//
//    public int getQuantity(RoomFindQuantityRequest request) {
//        return roomQuantityRepository.findByRoom_roomNoAndDate(request.getRoomNo(), LocalDate.now())
//                .getQuantity();
//    }
}
