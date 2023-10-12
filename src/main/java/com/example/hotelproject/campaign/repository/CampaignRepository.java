package com.example.hotelproject.campaign.repository;

import com.example.hotelproject.campaign.entity.Campaign;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign, Long>,
        CampaignCustomRepository {

    Optional<Campaign> findById(Long id);

    List<Campaign> findByServiceEndDate(LocalDateTime serviceEndDate);
}
