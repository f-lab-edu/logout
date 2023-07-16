package com.example.hotelproject.mapper;

import com.example.hotelproject.controller.request.UserCreateRequest;

import com.example.hotelproject.domain.User;
import com.example.hotelproject.domain.UserId;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends JpaRepository<User, UserId> {
    User save(
            UserCreateRequest userCreateRequest
    );

    List<User> findAll();
    //List<Object> findAll();
}
