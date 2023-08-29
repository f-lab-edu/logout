package com.example.hotelproject.repository;

import com.example.hotelproject.controller.request.hotel.HotelCreateRequest;
import com.example.hotelproject.domain.Hotel;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,Long> {

    Hotel save(HotelCreateRequest hotelCreateRequest);

    List<Hotel> findAll();

    boolean existsByHotelName(@Param("hotelName") String hotelName);

    void deleteById(@Param("id") Long id);

    List<Hotel> findHotelByHotelNameContains(@Param("hotelName") String name);

    //void update(Long id, HotelUpdateRequest hotelUpdateRequest);

    Optional<Hotel> findByHotelNo(Long hotelNo);

    List<Hotel> findAllByOwner_UserNo(@Param("ownerNo") Long ownerNo);
}
