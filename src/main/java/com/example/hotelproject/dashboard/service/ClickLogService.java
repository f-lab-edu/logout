package com.example.hotelproject.dashboard.service;

import com.example.hotelproject.dashboard.entity.ClickLog;
import com.example.hotelproject.dashboard.repository.ClickLogRepository;
import org.springframework.stereotype.Service;

@Service
public class ClickLogService {

    private final ClickLogRepository clickLogRepository;

    public ClickLogService(ClickLogRepository clickLogRepository) {
        this.clickLogRepository = clickLogRepository;
    }

    public void insertLog(ClickLog clickLog) {
        clickLogRepository.save(clickLog);
    }
}
