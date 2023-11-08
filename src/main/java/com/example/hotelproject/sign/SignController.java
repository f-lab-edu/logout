package com.example.hotelproject.sign;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sign")
public class SignController {

    private final SignService signService;

    public SignController(SignService signService) {
        this.signService = signService;
    }

    @PostMapping("/login")
    public SignResponse login(@RequestBody SignRequest request) {
        return signService.login(request);
    }

    @PostMapping("/join")
    public SignResponse join(@RequestBody SignRequest request) {
        return signService.join(request);
    }
}
