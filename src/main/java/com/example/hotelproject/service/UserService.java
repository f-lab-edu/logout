package com.example.hotelproject.service;

import com.example.hotelproject.controller.request.UserCreateRequest;
import com.example.hotelproject.controller.request.UserRegisterRequest;
import com.example.hotelproject.controller.response.UserRegisterResponse;
import com.example.hotelproject.controller.response.UserResponse;
import com.example.hotelproject.domain.User;
import com.example.hotelproject.repository.UserRepository;

import com.example.hotelproject.util.JwtUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public User create(UserCreateRequest request) {
        User user = request.toEntity();
        boolean isExistUser = userRepository.existsByUserId(user.getUserId());
        if (isExistUser) {
            throw new IllegalArgumentException("이미 가입된 회원입니다. : " + user.getUserId());
        }
        //BeanUtils.copyProperties(request, user);
        return userRepository.save(user);
    }

    public List<User> findAll() {
        List<User> list = userRepository.findAll();
        return list;
        //System.out.println(list.size());
    }

    public UserResponse findUserByUserId(String id) {
        return userRepository.findUserByUserId(id)
            .map(UserResponse::of)
            .orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다."));
    }

//    public User findByUserId(String id) {
//        return userRepository.findUserByUserId(id)
//            .orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다."));
//    }

    public void deleteByUserId(String id) {
        userRepository.deleteByUserId(id);
    }

//    public void registUser(String userId, String password) {
//        User user = new User(userId, passwordEncoder.encode(password), true);
//        userRepository.save(user);
//    }

    public UserRegisterResponse register(UserRegisterRequest request) {
        userRepository.findUserByUserId(request.getUserId())
            .ifPresent(user -> {throw new RuntimeException("유저 있음");});

        User saveUser = userRepository.save(request.toEntity(bCryptPasswordEncoder.encode(request.getPassword())));
        return new UserRegisterResponse(saveUser.getName());
    }

    public String login(String userId, String password) {
        User user = userRepository.findUserByUserId(userId)
            .orElseThrow(()-> new IllegalArgumentException("가입되지 않은 회원"));

        if(!bCryptPasswordEncoder.matches(password, user.getPassword())){
            throw new RuntimeException("비밀번호가 안맞음");
        }

        return JwtUtil.createToken(userId,expireTimeMs,secretkey);
    }

}
