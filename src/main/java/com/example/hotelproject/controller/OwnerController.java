package com.example.hotelproject.controller;


import com.example.hotelproject.controller.request.owner.OwnerCreateRequest;
import com.example.hotelproject.controller.request.owner.OwnerUpdateRequest;
import com.example.hotelproject.controller.response.owner.OwnerResponse;
import com.example.hotelproject.service.OwnerService;
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
    public OwnerResponse findOwnerById(@PathVariable("ownerId") String id) {
        return ownerService.findOwnerById(id);
    }

    @GetMapping()
    public List<OwnerResponse> findAll() {
        return ownerService.findAll();
    }

    //오너 삭제
    @DeleteMapping("/{userId}")
    public void deleteOwner(@PathVariable("ownerId") String id) {
        ownerService.deleteOwner(id);
    }

    //정보 수정
    @PostMapping("/update")
    public void updateOwnerInfo(@RequestBody OwnerUpdateRequest request) {
        ownerService.updateOwnerInfo(request);
    }


}
