package com.example.hotelproject.campaign.repository;

import com.example.hotelproject.campaign.entity.Campaign;
import java.util.List;

public interface CampaignCustomRepository {

    List<Campaign> findMatchingWithCampaignKind();

    List<Campaign> findWithCampaignInventoryIdAndKindId(Long inventoryId, Long kindId);

    //파워링크 검색
    List<Long> findPowerLinkCampaign(Long inventoryId, Long kindId);

    //검색 상단노출
    List<Long> findSearchCampaign(Long inventoryId, Long kindId);
}
