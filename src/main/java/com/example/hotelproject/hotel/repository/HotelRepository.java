package com.example.hotelproject.hotel.repository;

import com.example.hotelproject.hotel.controller.request.HotelCreateRequest;
import com.example.hotelproject.hotel.entity.Hotel;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,Long> {

    // 말씀 드린거긴 하지만, save는 선언 안해주셔도 됩니다 ~
    Hotel save(HotelCreateRequest hotelCreateRequest);

    List<Hotel> findAll();

    boolean existsByHotelName(@Param("hotelName") String hotelName);

    // 요것도 필요 없을 것 같아요 ~
    void deleteById(@Param("id") Long id);

    List<Hotel> findHotelByHotelNameContains(@Param("hotelName") String name);

    // 안쓰는 메서드는 주석보단 지워주는 습관을 들이는게 좋을 것 같아요 ~ 혹시 필요하면 어차피 깃에 남아있으니 언제든지 확인 가능합니다
    //void update(Long id, HotelUpdateRequest hotelUpdateRequest);

    Optional<Hotel> findByHotelNo(Long hotelNo);

    List<Hotel> findAllByOwner_OwnerNo(@Param("ownerNo") Long ownerNo);
}
