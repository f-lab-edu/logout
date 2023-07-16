package com.example.hotelproject.controller;
import com.example.hotelproject.controller.request.UserCreateRequest;
import com.example.hotelproject.controller.response.UserResponse;
import com.example.hotelproject.domain.User;
import com.example.hotelproject.service.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/users")
@RestController  // JSON 형태 결과값을 반환해줌 (@ResponseBody가 필요없음)
@RequiredArgsConstructor  // final 객체를 Constructor Injection 해줌. (Autowired 역할)
public class UserController {
    private final UserService userService;

//    public UserController(UserService userService) {
//        this.userService = userService;
//    }

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody UserCreateRequest request) {
        return ResponseEntity.ok(userService.save(request));
    }

    @GetMapping("/findAll")
    public List<User> findAll() {
        return userService.findAll();
    }

}
