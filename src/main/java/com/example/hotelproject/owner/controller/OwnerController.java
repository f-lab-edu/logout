package com.example.hotelproject.owner.controller;


import com.example.hotelproject.owner.controller.request.OwnerCreateRequest;
import com.example.hotelproject.owner.controller.request.OwnerUpdateRequest;
import com.example.hotelproject.owner.controller.response.OwnerResponse;
import com.example.hotelproject.owner.service.OwnerService;
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
    @GetMapping("/{ownerId}")
    public OwnerResponse findOwnerById(@PathVariable("ownerId") String id) {
        return ownerService.findOwnerById(id);
    }

    @GetMapping()
    public List<OwnerResponse> findAll() {
        return ownerService.findAll();
    }

    //오너 삭제
    @DeleteMapping("/{ownerId}")
    public void deleteOwner(@PathVariable("ownerId") String id) {
        ownerService.deleteOwner(id);
    }

    //정보 수정
    @PostMapping("/update")
    public void updateOwnerInfo(@RequestBody OwnerUpdateRequest request) {
        ownerService.updateOwnerInfo(request);
    }


}
