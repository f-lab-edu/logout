//package com.example.hotelproject.controller;
//
//import com.example.hotelproject.controller.request.UserLoginRequest;
//import com.example.hotelproject.controller.request.UserRegisterRequest;
//import com.example.hotelproject.controller.response.UserLoginResponse;
//import com.example.hotelproject.controller.response.UserRegisterResponse;
//import com.example.hotelproject.service.LoginService;
//import com.example.hotelproject.service.OwnerService;
//import com.example.hotelproject.service.UserService;
//import com.example.hotelproject.util.JwtProvider;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("api/v1/login")
//public class LoginController {
//    private LoginService loginService;
//
//    public LoginController(LoginService loginService) {
//        this.loginService = loginService;
//    }
//
//    @PostMapping("/register")
//    @ApiOperation(value = "회원가입", notes = "사용자 회원가입")
//    public UserRegisterResponse register(@RequestBody UserRegisterRequest userRegisterRequest) {
//        try {
//            UserRegisterResponse regitUser = loginService.register(userRegisterRequest);
//            return new UserRegisterResponse(regitUser.getName());
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new IllegalArgumentException("오류");
//        }
//    }
//
//    @PostMapping("/login")
//    @ApiOperation(value = "로그인", notes ="사용자 로그인")
//    public UserLoginResponse login(@RequestBody UserLoginRequest userLoginRequest) {
//        try {
//            String token = loginService.login(userLoginRequest);
//            return new UserLoginResponse(token);
//        } catch (Exception e) {
//            e.printStackTrace();
//            //return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//            throw new IllegalArgumentException("오류");
//        }
//    }
//
//
//}
