package com.example.hotelproject.controller;

import com.example.hotelproject.controller.request.UserCreateRequest;
import com.example.hotelproject.controller.response.OwnerResponse;
import com.example.hotelproject.controller.response.UserResponse;
import com.example.hotelproject.service.UserService;
import lombok.experimental.PackagePrivate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RequestMapping("api/v1/users")
@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public void createUser(@RequestBody UserCreateRequest request) {
        userService.saveUser(request);
    }

//    @PostMapping("/create")
//    public ResponseEntity<UserResponse> createUser(@RequestBody UserCreateRequest request) {
//        userService.saveUser(request);
//        return new ResponseEntity<UserResponse>(new UserResponse(), HttpStatus.ACCEPTED);
//    }

    @GetMapping("/findAll")
    public void findAll() {
        userService.findAll();
    }

//    @GetMapping("")
//    public List<UserResponse> getAllUser(UserResponse userResponse) {
//        return userService.getAllUser();
//    }
//
//    @GetMapping("/{id}")
//    public UserResponse getUser(@PathVariable("id") String id){
//        return userService.findUser(id);
//    }

}
