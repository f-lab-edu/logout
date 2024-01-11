package com.example.hotelproject.dashboard.controller;

import com.example.hotelproject.dashboard.service.DashboardService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/dashboard")
public class DashboardController {

    public final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/monthly/clickCount")
    public List<Long> monthlyInventoryClickCount(@RequestParam Long inventoryId) {
        return dashboardService.monthlyInventoryClickCount(inventoryId);
    }

    @GetMapping("/daily/sales")
    public Integer todaySales(@RequestParam Long hotelNo) {
        return dashboardService.todaySales(hotelNo);
    }
}
