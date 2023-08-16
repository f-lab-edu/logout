package com.example.hotelproject.controller;

import com.example.hotelproject.controller.request.OwnerCreateRequest;
import com.example.hotelproject.controller.request.OwnerUpdateRequest;
import com.example.hotelproject.controller.response.HotelResponse;
import com.example.hotelproject.controller.response.OwnerResponse;
import com.example.hotelproject.controller.response.OwnersHotelsResponse;
import com.example.hotelproject.service.OwnerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/owners")
@RestController
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    //오너 신규 추가
    @PostMapping("/create")
    public OwnerResponse createOwner(@RequestBody OwnerCreateRequest request) {
        return ownerService.create(request);
    }

    //오너 검색
    @GetMapping("/{userId}")
    public OwnerResponse findOwnerById(@PathVariable("userId") String id) {
        return ownerService.findOwnerById(id);
    }

    @GetMapping()
    public List<OwnerResponse> findAll() {
        return ownerService.findAll();
    }

    //오너 삭제
    @DeleteMapping("/{userId}")
    public void deleteOwner(@PathVariable("userId") String id) {
        ownerService.deleteOwner(id);
    }

    //정보 수정
    @PostMapping("/update")
    public void updateOwnerInfo(@RequestBody OwnerUpdateRequest request) {
        ownerService.updateOwnerInfo(request);
    }

    @GetMapping("/myHotels/userId}")
    @ApiOperation(value = "owner 별 호텔 조회", notes = "해당 오너의 호텔리스트 조회함")
    public List<OwnersHotelsResponse> findMyHotels(@PathVariable("userNo") int ownerNo){
        return ownerService.findMyHotels(ownerNo);
    }


}
