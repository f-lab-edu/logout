package com.example.hotelproject.hotel.controller;


import com.example.hotelproject.hotel.controller.request.HotelCreateRequest;
import com.example.hotelproject.hotel.controller.request.HotelSearchRequest;
import com.example.hotelproject.hotel.controller.request.HotelUpdateRequest;
import com.example.hotelproject.hotel.controller.response.HotelResponse;
import com.example.hotelproject.hotel.service.HotelService;
import com.example.hotelproject.owner.controller.response.OwnersHotelsResponse;
import com.example.hotelproject.review.controller.request.PageRequest;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.data.domain.PageImpl;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Hotels", description = "호텔 API")
@RequestMapping("api/v1/hotel")
@RestController
public class HotelController {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping("/create")
    @ApiOperation(value = "호텔 신규등록", notes = "owner가 호텔을 등록합니다.")
    public Long create(@RequestBody HotelCreateRequest request) {
        return hotelService.create(request);
    }

    @GetMapping()
    @ApiOperation(value = "호텔 조회", notes = "호텔을 전체 조회합니다.")
    public List<HotelResponse> findAll() {
        return hotelService.findAll();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "호텔 삭제", notes = "호텔을 삭제합니다.")
    public void delete(@PathVariable("id") Long id) {
        hotelService.deleteById(id);
    }

    @GetMapping("/{hotelName}")
    @ApiOperation(value = "호텔 이름 검색", notes = "호텔을 이름으로 검색합니다.")
    public List<HotelResponse> findHotelByName(@PathVariable("hotelName") String name) {
        return hotelService.findHotelByName(name);
    }

    //정보 수정
    @PostMapping("/update/{id}")
    @ApiOperation(value = "호텔 정보 수정", notes = "호텔정보를 수정합니다.")
    public Long updateHotelInfo(@PathVariable("id") Long id,
            @RequestBody HotelUpdateRequest request) {
        return hotelService.update(id, request);
    }

    @GetMapping("/myHotels/userId}")
    @ApiOperation(value = "owner 별 호텔 조회", notes = "해당 오너의 호텔리스트 조회함")
    public List<OwnersHotelsResponse> findMyHotels(@PathVariable("userNo") Long ownerNo) {
        return hotelService.findMyHotels(ownerNo);
    }

    @GetMapping("/search")
    public PageImpl<HotelResponse> searchHotels(@RequestBody HotelSearchRequest hotelSearchRequest,
            PageRequest pageRequest) {
        return hotelService.searchHotels(hotelSearchRequest, pageRequest);
    }
}
