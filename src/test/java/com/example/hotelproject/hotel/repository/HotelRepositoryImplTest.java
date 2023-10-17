package com.example.hotelproject.hotel.repository;

import com.example.hotelproject.hotel.controller.request.HotelSearchRequest;
import com.example.hotelproject.hotel.entity.Hotel;
import com.example.hotelproject.review.controller.request.PageRequest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@SpringBootTest
class HotelRepositoryImplTest {

    private HotelRepository hotelRepository;

    @Autowired
    HotelRepositoryImplTest(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Test
    @Transactional(readOnly = true)
    void searchHotels() {
        PageRequest pageRequest = new PageRequest();
        Pageable pageable = pageRequest.of();
        HotelSearchRequest request = HotelSearchRequest.builder()
                .grade(4)
                .build();
        Hotel hotel = request.toEntity();
        PageImpl<Hotel> hotels = hotelRepository.searchHotels(pageable, hotel);
        System.out.println(hotels);
        log.info("result : {}", hotels);
    }
}