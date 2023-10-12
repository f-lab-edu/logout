package com.example.hotelproject.campaign.controller.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CampaignDeleteRequest {

    private Long campaignId;
    private boolean delete;

    @Builder
    public CampaignDeleteRequest(Long campaignId, boolean delete) {
        this.campaignId = campaignId;
        this.delete = delete;
    }

}
