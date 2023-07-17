package com.example.hotelproject.service;

import com.example.hotelproject.controller.request.HotelCreateRequest;
import com.example.hotelproject.controller.request.HotelUpdateRequest;
import com.example.hotelproject.controller.response.HotelResponse;
import com.example.hotelproject.mapper.HotelMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class HotelService {
    private final HotelMapper hotelMapper;

    public HotelService(HotelMapper hotelMapper) {
        this.hotelMapper = hotelMapper;
    }

    //호텔 신규 추가
    public void createHotel(HotelCreateRequest request){
        if(!hotelMapper.checkExistName(request.getHotelName())){
            hotelMapper.createHotel(request);
        }else{
            throw new IllegalArgumentException("같은 이름의 호텔이 있습니다.(" + request.getHotelName()+ ")");
        }
    }

    //전체조회
    public List<HotelResponse> findAll(){
        return hotelMapper.findAll().stream()
            .map(HotelResponse::of)
            .collect(Collectors.toList());
    }

    //삭제
    public void deleteHotel(int no){
        hotelMapper.deleteHotel(no);
    }

    //이름으로 검색
    public HotelResponse findHotelByName(@PathVariable("hotelName") String name){
        return hotelMapper.findHotelByName(name)
            .map(HotelResponse::of)
            .orElseThrow(()-> new IllegalArgumentException("해당 이름의 호텔이 없습니다."));
    }

    //호텔 정보 수정
    public void updateHotelInfo(HotelUpdateRequest request){
        hotelMapper.updateHotelInfo(request);
    }

}
