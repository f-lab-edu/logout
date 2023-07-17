package com.example.hotelproject.mapper;

import com.example.hotelproject.controller.request.UserCreateRequest;

import com.example.hotelproject.controller.response.UserResponse;
import com.example.hotelproject.domain.User;
import com.example.hotelproject.domain.UserId;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserMapper extends JpaRepository<User, UserId> {
    User save(
            UserCreateRequest userCreateRequest
    );

    List<User> findAll();

    Optional<User> findUserByUserId(@Param("userId") String userId);
    //List<Object> findAll();

    @Transactional
    void deleteByUserId(@Param("userId") String userId);

    boolean existsByUserId(String userId);
}
