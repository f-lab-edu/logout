package com.example.hotelproject.service;

import com.example.hotelproject.controller.request.UserCreateRequest;
import com.example.hotelproject.controller.request.UserRegisterRequest;
import com.example.hotelproject.controller.response.UserLoginResponse;
import com.example.hotelproject.controller.response.UserRegisterResponse;
import com.example.hotelproject.controller.response.UserResponse;
import com.example.hotelproject.domain.User;
import com.example.hotelproject.repository.UserRepository;

import com.example.hotelproject.util.JwtUtil;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Value("${jwt.token.secret}")
    private String secretkey;
    private final long expireTimeMs = 1000 * 60 * 60 * 24 * 7; // 토큰 7일

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder,
        BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Transactional
    public String create(UserCreateRequest request) {
        User user = request.toEntity();
        boolean isExistUser = userRepository.existsByUserId(user.getUserId());
        if (isExistUser) {
            throw new IllegalArgumentException("이미 가입된 회원입니다. : " + user.getUserId());
        }
        return userRepository.save(user).getUserId();
    }

    @Transactional(readOnly = true)
    public List<UserResponse> findAll() {
        return userRepository.findAll()
            .stream().map(UserResponse::of)
            .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public UserResponse findUserByUserId(String id) {
        return userRepository.findUserByUserId(id)
            .map(UserResponse::of)
            .orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다."));
    }


    @Transactional
    public void deleteByUserId(String id) {
        userRepository.deleteByUserId(id);
    }

    @Transactional
    public UserRegisterResponse register(UserRegisterRequest request) {
        userRepository.findUserByUserId(request.getUserId())
            .ifPresent(user -> {throw new RuntimeException("유저 있음");});

        User saveUser = userRepository.save(request.toEntity(bCryptPasswordEncoder.encode(request.getPassword())));
        return new UserRegisterResponse(saveUser.getName());
    }

    @Transactional
    public String login(String userId, String password) {
        User user = userRepository.findUserByUserId(userId)
            .orElseThrow(()-> new IllegalArgumentException("가입되지 않은 회원"));

        if(!bCryptPasswordEncoder.matches(password, user.getPassword())){
            throw new RuntimeException("비밀번호가 안맞음");
        }

        return JwtUtil.createToken(userId,expireTimeMs,secretkey);
    }

//    public String logout(UserLoginResponse response){
//
//    }

}
