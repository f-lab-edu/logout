package com.example.hotelproject.hotel.repository;

import com.example.hotelproject.hotel.entity.HotelOptions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelOptionsRepository extends JpaRepository<HotelOptions, Long> {

}
