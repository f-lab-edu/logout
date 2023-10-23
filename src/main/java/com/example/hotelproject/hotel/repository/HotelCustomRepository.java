package com.example.hotelproject.hotel.repository;

import com.example.hotelproject.hotel.entity.Hotel;
import java.time.LocalDateTime;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface HotelCustomRepository {

    Slice<Hotel> searchHotelsBasicScroll(Long cursorId, Pageable pageable, Hotel hotel);

    PageImpl<Hotel> sortingByScore(Pageable pageable, Hotel hotel);

    PageImpl<Hotel> searchHotelsNew(Long lastId, Pageable pageable, Hotel hotelInfo,
            LocalDateTime startDate, LocalDateTime endDate);

}
