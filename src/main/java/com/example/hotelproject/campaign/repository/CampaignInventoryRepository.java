package com.example.hotelproject.campaign.repository;

import com.example.hotelproject.campaign.entity.CampaignInventory;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampaignInventoryRepository extends JpaRepository<CampaignInventory, Long> {

    Optional<CampaignInventory> findByName(String name);
}
