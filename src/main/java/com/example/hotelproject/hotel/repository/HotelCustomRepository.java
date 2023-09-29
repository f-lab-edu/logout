package com.example.hotelproject.hotel.repository;

import com.example.hotelproject.hotel.entity.Hotel;
import com.example.hotelproject.hotel.entity.HotelOption;
import java.util.List;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public interface HotelCustomRepository {

    PageImpl<Hotel> searchHotels(Pageable pageable, Hotel hotel);
}