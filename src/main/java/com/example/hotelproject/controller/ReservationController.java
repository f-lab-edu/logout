package com.example.hotelproject.controller;

import com.example.hotelproject.controller.request.reservation.ReservationCancelRequest;
import com.example.hotelproject.controller.request.reservation.ReservationCreateRequest;
import com.example.hotelproject.controller.response.reservation.ReservationDetailResponse;
import com.example.hotelproject.service.ReservationService;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/reservation")
public class ReservationController {

    private ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping()
    @ApiOperation(value = "호텔 예약", notes = "user가 호텔을 예약합니다.")
    public Long reserve(@RequestBody ReservationCreateRequest request){
        return reservationService.create(request);
    }

    @GetMapping("/{userNo}")
    @ApiOperation(value = "호텔 예약내역", notes = "user 호텔 예약내역을 조회합니다.")
    public List<ReservationDetailResponse> reservationList(@PathVariable("userNo") Long userNo){
        return reservationService.findAllByUserNo(userNo);
    }

    @PostMapping("/cancel")
    @ApiOperation(value = "호텔 예약취소", notes = "user 호텔 예약을 취소합니다.")
    public void cancel(@RequestBody
        ReservationCancelRequest request){
        reservationService.cancel(request);
    }



}
