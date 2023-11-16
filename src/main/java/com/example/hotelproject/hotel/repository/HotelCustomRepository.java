package com.example.hotelproject.hotel.repository;

import com.example.hotelproject.hotel.entity.Hotel;
import com.example.hotelproject.hotel.entity.HotelFilter;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public interface HotelCustomRepository {

    List<Hotel> searchHotelsBasic(Long cursorId, int limit, HotelFilter filter);

    PageImpl<Hotel> sortingByScore(Pageable pageable, Hotel hotel);

    PageImpl<Hotel> searchHotelsNew(Long lastId, Pageable pageable, Hotel hotelInfo,
            LocalDateTime startDate, LocalDateTime endDate);

}
