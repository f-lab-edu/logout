package com.example.hotelproject.campaign.controller.response;

import com.example.hotelproject.campaign.entity.Campaign;
import com.example.hotelproject.campaign.entity.CampaignKind;
import com.example.hotelproject.hotel.entity.Hotel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CampaignSearchResponse {

    private CampaignKind campaignKind;
    private Campaign campaign;
    private Hotel hotel;

    @Builder
    public CampaignSearchResponse(CampaignKind campaignKind, Campaign campaign,
            Hotel hotel) {
        this.campaignKind = campaignKind;
        this.campaign = campaign;
        this.hotel = hotel;
    }

    public static CampaignSearchResponse of(Campaign campaign) {
        return CampaignSearchResponse.builder()
                .campaign(campaign)
                .campaignKind(campaign.getCampaignKind())
                .hotel(campaign.getHotel())
                .build();
    }
}
