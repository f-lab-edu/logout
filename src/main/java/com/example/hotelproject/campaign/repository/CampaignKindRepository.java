package com.example.hotelproject.campaign.repository;

import com.example.hotelproject.campaign.entity.CampaignKind;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampaignKindRepository extends JpaRepository<CampaignKind, Long> {

    Optional<CampaignKind> findById(Long id);

    Optional<CampaignKind> findByKindKey(String kindKey);
}
