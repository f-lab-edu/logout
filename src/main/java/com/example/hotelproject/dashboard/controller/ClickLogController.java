package com.example.hotelproject.dashboard.controller;

import com.example.hotelproject.dashboard.entity.ClickLog;
import com.example.hotelproject.dashboard.service.ClickLogService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/clickLog")
public class ClickLogController {

    private ClickLogService clickLogService;

    public ClickLogController(ClickLogService clickLogService) {
        this.clickLogService = clickLogService;
    }

    @PostMapping("/insert")
    public void insertLog(@RequestBody ClickLog click) {
        clickLogService.insertLog(click);
    }
}
