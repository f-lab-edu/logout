package com.example.hotelproject.service;

import com.example.hotelproject.controller.request.UserCreateRequest;
import com.example.hotelproject.domain.User;
import com.example.hotelproject.mapper.UserMapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User save(UserCreateRequest request) {
        User user = request.toEntity();
        //BeanUtils.copyProperties(request, user);
        return userMapper.save(user);
        // return "저장되었습니다.";
    }

    public List<User> findAll() {
        List<User> list = userMapper.findAll();
        return list;
        //list.forEach(System.out::println);
        //System.out.println(list.size());
    }

}
