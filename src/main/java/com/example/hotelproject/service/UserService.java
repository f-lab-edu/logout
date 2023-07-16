package com.example.hotelproject.service;

import com.example.hotelproject.controller.request.UserCreateRequest;
import com.example.hotelproject.controller.response.UserResponse;
import com.example.hotelproject.domain.User;
import com.example.hotelproject.mapper.UserMapper;

import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User create(UserCreateRequest request) {
        User user = request.toEntity();
        boolean isExistUser = userMapper.existsByUserId(user.getUserId());
        if (isExistUser) {
            throw new IllegalArgumentException("이미 가입된 회원입니다. : " + user.getUserId());
        }
        //BeanUtils.copyProperties(request, user);
        return userMapper.save(user);
    }

    public List<User> findAll() {
        List<User> list = userMapper.findAll();
        return list;
        //System.out.println(list.size());
    }

    public UserResponse findUserByUserId(String id) {
        return userMapper.findUserByUserId(id)
            .map(UserResponse::of)
            .orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다."));
    }

    public void deleteUserByUserId(String id) {
        userMapper.deleteUserByUserId(id);
    }

}
