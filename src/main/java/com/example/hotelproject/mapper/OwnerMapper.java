package com.example.hotelproject.mapper;

import com.example.hotelproject.controller.request.OwnerCreateRequest;
import com.example.hotelproject.controller.request.UserCreateRequest;
import com.example.hotelproject.controller.response.OwnerResponse;
import com.example.hotelproject.domain.Owner;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerMapper {
    void createOwner(
            OwnerCreateRequest ownerCreateRequest
    );

    List<Owner> findAll();

    Optional<Owner> findOwnerById(@Param("userId") String id);

    boolean checkExistId(@Param("userId") String id);

    void deleteOwner(@Param("userId") String id);

    void updateOwnerInfo(
            OwnerCreateRequest ownerCreateRequest
    );
}
