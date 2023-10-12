package com.example.hotelproject.room.controller;

import com.example.hotelproject.room.controller.request.RoomCancelQuantityRequest;
import com.example.hotelproject.room.controller.request.RoomFindQuantityRequest;
import com.example.hotelproject.room.controller.request.RoomReservationQuantityRequest;
import com.example.hotelproject.room.service.RoomService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Room", description = "room API")
@RequestMapping("api/v1/room")
@RestController
public class RoomController {

    private RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping("/quantity/reservation")
    @ApiOperation(value = "room 수량 업데이트", notes = "예약시 룸 수량을 업데이트 합니다.")
    public void reservationQuantity(@RequestBody RoomReservationQuantityRequest request) {
        roomService.MaxQuantitySetting(request);
    }

    @PostMapping("/quantity/cancel")
    @ApiOperation(value = "room 수량 업데이트", notes = "예약취소시 룸 수량을 업데이트 합니다.")
    public void cancelQuantity(@RequestBody RoomCancelQuantityRequest request) {
        roomService.cancelQuantitySetting(request);
    }

    @GetMapping
    @ApiOperation(value = "room 수량 조회", notes = "특정 룸 수량을 조회 합니다.")
    public int getQuantity(@RequestBody RoomFindQuantityRequest request) {
        return roomService.getQuantity(request);
    }


}
