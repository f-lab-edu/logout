package com.example.hotelproject.mapper;

import com.example.hotelproject.controller.request.UserCreateRequest;

import java.util.List;

public interface UserMapper {
    void saveUser(
            UserCreateRequest userCreateRequest
    );

    List<Object> findAll();
}
