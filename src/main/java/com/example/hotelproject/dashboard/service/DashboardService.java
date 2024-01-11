package com.example.hotelproject.dashboard.service;

import com.example.hotelproject.dashboard.repository.ClickLogRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    private final ClickLogRepository clickLogRepository;

    public DashboardService(ClickLogRepository clickLogRepository) {
        this.clickLogRepository = clickLogRepository;
    }

    //지면별 클릭수
    public List<Long> monthlyInventoryClickCount(Long inventoryId) {
        return clickLogRepository.monthlyCountByInventoryId(inventoryId);
    }

    //호텔별 당일 매출
    public Integer todaySales(Long hotelNo) {
        return clickLogRepository.todaySales(hotelNo);
    }

    //호텔별 월별 매출
    public Integer monthlySales(Long hotelNo, String yearMonth) {
        return clickLogRepository.monthlySales(hotelNo, yearMonth);
    }

    //캠패인별 연령별 클릭수

}
