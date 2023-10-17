package com.example.hotelproject.hotel.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.hotelproject.hotel.entity.Hotel;
import com.example.hotelproject.hotel.repository.HotelRepository;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@SpringBootTest
class HotelServiceTest {

    private HotelRepository hotelRepository;

    @Autowired
    HotelServiceTest(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Test
    @Transactional(readOnly = true)
    void findAll() {
        List<Hotel> hotelList = hotelRepository.findAll();

        System.out.println(hotelList);
        assertThat(hotelList).isNotNull();
    }
}