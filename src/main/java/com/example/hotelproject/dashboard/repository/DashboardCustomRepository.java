package com.example.hotelproject.dashboard.repository;

import com.querydsl.core.Tuple;
import java.util.List;

public interface DashboardCustomRepository {

    //월별 인벤토리 클릭 수 통계
    List<Long> monthlyCountByInventoryId(Long inventoryId);

    //당일 매출
    Integer todaySales(Long hotelNo);

    Integer monthlySales(Long hotelNo, String yearMonth);

    List<Tuple> campaignClicksByAge(Long campaignId);
}
