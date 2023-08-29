//package com.example.hotelproject.service;
//
//import com.example.hotelproject.controller.request.user.UserLoginRequest;
//import com.example.hotelproject.controller.request.user.UserRegisterRequest;
//import com.example.hotelproject.controller.response.user.UserRegisterResponse;
//import com.example.hotelproject.domain.User;
//import com.example.hotelproject.repository.UserRepository;
//import com.example.hotelproject.util.JwtProvider;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//public class LoginService {
//
//    private UserRepository userRepository;
//    private final JwtProvider jwtProvider;
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    public LoginService(UserRepository userRepository,
//        JwtProvider jwtProvider) {
//        this.userRepository = userRepository;
//        this.jwtProvider = jwtProvider;
//    }
//
//
//    public UserRegisterResponse register(UserRegisterRequest request) {
//        userRepository.findUserByUserId(request.getUserId())
//            .ifPresent(user -> {throw new RuntimeException("유저 있음");});
//
//        User regitUser = userRepository.save(request.toEntity(bCryptPasswordEncoder.encode(request.getPassword())));
//        return new UserRegisterResponse(regitUser.getUserId());
//    }
//
//    public String login(UserLoginRequest request) {
//        User user = userRepository.findUserByUserId(request.getUserId())
//            .orElseThrow(() -> new UsernameNotFoundException("가입되지 않은 회원입니다."));
//
//        return jwtProvider.createTokenByRole(user.getUserId(), user.getRole());
//
//    }
//}
