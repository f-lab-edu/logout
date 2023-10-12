package com.example.hotelproject.campaign.controller.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CampaignSearchRequest {

    private Long campaignKindId;
    private Long campaignInventoryId;

    @Builder
    public CampaignSearchRequest(Long campaignKindId, Long campaignInventoryId) {
        this.campaignKindId = campaignKindId;
        this.campaignInventoryId = campaignInventoryId;
    }

}
