package com.example.hotelproject.hotel.repository;

import com.example.hotelproject.hotel.entity.HotelOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelOptionRepository extends JpaRepository<HotelOption, Long> {

    HotelOption findByCode(String optionCode);
}
