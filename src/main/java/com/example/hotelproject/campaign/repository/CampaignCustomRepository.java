package com.example.hotelproject.campaign.repository;

import com.example.hotelproject.campaign.entity.Campaign;
import java.util.List;

public interface CampaignCustomRepository {

    List<Campaign> findMatchingWithCampaignKind();

    List<Campaign> findWithCampaignInventoryIdAndKindId(Long inventoryId, Long kindId);
}
