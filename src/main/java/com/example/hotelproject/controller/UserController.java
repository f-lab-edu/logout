package com.example.hotelproject.controller;
import com.example.hotelproject.controller.request.UserCreateRequest;
import com.example.hotelproject.controller.request.UserLoginRequest;
import com.example.hotelproject.controller.request.UserRegisterRequest;
import com.example.hotelproject.controller.response.UserLoginResponse;
import com.example.hotelproject.controller.response.UserRegisterResponse;
import com.example.hotelproject.controller.response.UserResponse;
import com.example.hotelproject.domain.User;
import com.example.hotelproject.service.UserService;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/users")
@RestController  // JSON 형태 결과값을 반환해줌 (@ResponseBody가 필요없음)
//@RequiredArgsConstructor  // final 객체를 Constructor Injection 해줌. (Autowired 역할)
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ApiOperation(value = "user 등록/생성", notes = "신규 user를 등록/생성합니다.")
    public ResponseEntity<User> createUser(@RequestBody UserCreateRequest request) {
        return ResponseEntity.ok(userService.create(request));
    }

    @GetMapping
    @ApiOperation(value = "user 전체 조회", notes = "기존 user를 전체 조회합니다.")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{userId}")
    @ApiOperation(value = "user 검색", notes = "user를 검색합니다.")
    public ResponseEntity<UserResponse> findUserByUserId(@PathVariable("userId") String id){
        return ResponseEntity.ok(userService.findUserByUserId(id));
    }

    @DeleteMapping("/{userId}")
    @ApiOperation(value = "user 삭제", notes = "해당 유저를 삭제합니다.")
    public void deleteByUserId(@PathVariable("userId") String userId){
        userService.deleteByUserId(userId);
    }



    @PostMapping("/register")
    public UserRegisterResponse register(@RequestBody UserRegisterRequest userRegisterRequest) {
        try {
            UserRegisterResponse regitUser = userService.register(userRegisterRequest);
            return new UserRegisterResponse(regitUser.getName());
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException("오류");
        }
    }

    @PostMapping("/login")
    public UserLoginResponse login(@RequestBody UserLoginRequest userLoginRequest) {
        try {
            String token = userService.login(userLoginRequest.getUserId(), userLoginRequest.getPassword());
            return new UserLoginResponse(token);
        } catch (Exception e) {
            e.printStackTrace();
            //return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            throw new IllegalArgumentException("오류");
        }
    }

}
