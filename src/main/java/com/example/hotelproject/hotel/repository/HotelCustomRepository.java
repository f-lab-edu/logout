package com.example.hotelproject.hotel.repository;

import com.example.hotelproject.hotel.entity.Hotel;
import com.example.hotelproject.hotel.entity.HotelFilter;
import java.util.List;

public interface HotelCustomRepository {

    List<Hotel> searchHotelsBasic(Long cursorId, int limit, HotelFilter filter);

    List<Hotel> sortingByScore(Long cursorId, int limit, HotelFilter filter);

    List<Hotel> findAllByOptions(List<String> optionCode);

    List<Hotel> findAllByHotelNo(List<Long> hotelNoList, boolean campaign);
}
