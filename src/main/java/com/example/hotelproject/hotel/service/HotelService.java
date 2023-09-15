package com.example.hotelproject.hotel.service;

import com.example.hotelproject.hotel.controller.request.HotelCreateRequest;
import com.example.hotelproject.hotel.controller.request.HotelUpdateRequest;
import com.example.hotelproject.hotel.controller.response.HotelResponse;
import com.example.hotelproject.owner.controller.response.OwnersHotelsResponse;
import com.example.hotelproject.hotel.entity.Hotel;
import com.example.hotelproject.hotel.repository.HotelRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class HotelService {
    private final HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Transactional
    public Long create(HotelCreateRequest request){
        Hotel hotel = request.toEntity();

        if(hotelRepository.existsByHotelName(hotel.getHotelName())){
            // IllegalArgumentException은 자주 사용하는 예외인데요, ExceptionHandler에서 해당 예외에 대한 처리도 있으면 좋을 것 같습니다 ~
            throw new IllegalArgumentException("같은 이름의 호텔이 있습니다.(" + request.getHotelName()+ ")");
        }
        return hotelRepository.save(request).getHotelNo();
    }

    //전체조회
    @Transactional(readOnly = true)
    public List<HotelResponse> findAll(){
        return hotelRepository.findAll().stream()
            .map(HotelResponse::of)
            .collect(Collectors.toList());
    }

    //삭제
    @Transactional
    public void deleteById(Long id){
        hotelRepository.deleteById(id);
    }

    // 이 서비스 도메인이 Hotel이라 메서드에 Hotel은 굳이 명시 안해줘도 될 것 같아요 ~
    //이름으로 검색
    @Transactional(readOnly = true)
    public List<HotelResponse> findHotelByName(@PathVariable("hotelName") String name){
        return hotelRepository.findHotelByHotelNameContains(name).stream()
            .map(HotelResponse::of)
            .collect(Collectors.toList());
    }

    //호텔 정보 수정
    @Transactional
    public Long update(Long hotelNo, HotelUpdateRequest request){
        Hotel hotel = hotelRepository.findByHotelNo(hotelNo)
            .orElseThrow(()-> new IllegalArgumentException("해당 호텔이 없습니다. id : "+ hotelNo));

        hotel.update(hotelNo, request);
        return hotel.getHotelNo();
    }

    @Transactional(readOnly = true)
    public List<OwnersHotelsResponse> findMyHotels(Long ownerNo){
        return hotelRepository.findAllByOwner_OwnerNo(ownerNo)
            .stream().map(OwnersHotelsResponse::of)
            .collect(Collectors.toList());
    }

}
