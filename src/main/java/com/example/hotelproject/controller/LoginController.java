package com.example.hotelproject.controller;

import com.example.hotelproject.domain.User;
import com.example.hotelproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1")
@RestController
public class LoginController {
    private UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public String login(@RequestParam String userId, @RequestParam String password) {
        // Spring Security가 인증 처리를 하므로 별도의 로그인 로직은 필요 없음
        return "Login successful!";
    }

    @PostMapping("/register")
    public String register(@RequestParam String userId, @RequestParam String password) {
        return  "";
    }
}
