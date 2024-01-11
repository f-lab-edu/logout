package com.example.hotelproject.dashboard.repository;

import com.example.hotelproject.dashboard.entity.ClickLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClickLogRepository extends JpaRepository<ClickLog, Long>,
        DashboardCustomRepository {

}
