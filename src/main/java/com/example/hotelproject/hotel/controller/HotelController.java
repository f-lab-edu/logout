package com.example.hotelproject.hotel.controller;


import com.example.hotelproject.hotel.controller.request.HotelCreateRequest;
import com.example.hotelproject.hotel.controller.request.HotelUpdateRequest;
import com.example.hotelproject.hotel.controller.response.HotelResponse;
import com.example.hotelproject.owner.controller.response.OwnersHotelsResponse;
import com.example.hotelproject.hotel.service.HotelService;
import io.swagger.annotations.ApiOperation;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/hotel")
@RestController
public class HotelController {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    // 여기도 Swagger로 변경이 필요할 것 같아요 ~
    //호텔 신규 등록
    @PostMapping("/create")
    public Long create(@RequestBody HotelCreateRequest request) {
        return hotelService.create(request);
    }

    //전체조회
    @GetMapping()
    public List<HotelResponse> findAll() {
        return hotelService.findAll();
    }

    //삭제
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        hotelService.deleteById(id);
    }

    //이름으로 검색
    @GetMapping("/{hotelName}")
    public List<HotelResponse> findHotelByName(@PathVariable("hotelName") String name){
        return hotelService.findHotelByName(name);
    }

    //정보 수정
    @PostMapping("/update/{id}")
    public Long updateHotelInfo(@PathVariable("id") Long id, @RequestBody HotelUpdateRequest request){
        return hotelService.update(id, request);
    }

    @GetMapping("/myHotels/userId}")
    @ApiOperation(value = "owner 별 호텔 조회", notes = "해당 오너의 호텔리스트 조회함")
    public List<OwnersHotelsResponse> findMyHotels(@PathVariable("userNo") Long ownerNo){
        return hotelService.findMyHotels(ownerNo);
    }

}
