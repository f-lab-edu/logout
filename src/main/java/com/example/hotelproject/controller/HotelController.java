package com.example.hotelproject.controller;

import com.example.hotelproject.controller.request.HotelCreateRequest;
import com.example.hotelproject.controller.request.HotelUpdateRequest;
import com.example.hotelproject.controller.response.HotelResponse;
import com.example.hotelproject.service.HotelService;
import java.util.List;
import org.springframework.http.ResponseEntity;
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
}
