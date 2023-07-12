package com.example.hotelproject.mapper;

import com.example.hotelproject.controller.request.HotelCreateRequest;
import com.example.hotelproject.controller.request.HotelUpdateRequest;
import com.example.hotelproject.domain.Hotel;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Param;

public interface HotelMapper {
    void createHotel(
            HotelCreateRequest hotelCreateRequest
    );

    boolean checkExistName(@Param("hotelName") String hotelName);

    void deleteHotel(@Param("hotelNo") int hotelNo);

    List<Hotel> findAll();

    Optional<Hotel> findHotelByName(@Param("hotelName") String name);

    void updateHotelInfo(
        HotelUpdateRequest hotelUpdateRequest
    );
}
