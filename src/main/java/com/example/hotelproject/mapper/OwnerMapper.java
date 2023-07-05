package com.example.hotelproject.mapper;

import com.example.hotelproject.controller.request.OwnerCreateRequest;
import com.example.hotelproject.controller.request.UserCreateRequest;
import com.example.hotelproject.controller.response.OwnerResponse;
import com.example.hotelproject.domain.Owner;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface OwnerMapper {
    void createOwner(
            OwnerCreateRequest ownerCreateRequest
    );

    List<Object> getAllOwner();

    OwnerResponse findOwnerById(@Param("userId") String id);

    void deleteOwner(@Param("userId") String id);

    void updateOwnerInfo(
            OwnerCreateRequest ownerCreateRequest
    );
}
