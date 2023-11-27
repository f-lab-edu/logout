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

    private CampaignKind campaignKind;  //이거 왜썼지?
    private Campaign campaign;
    private Long hotelNo;

    @Builder
    public CampaignSearchResponse(CampaignKind campaignKind, Campaign campaign,
            Hotel hotel, Long hotelNo) {
        this.campaignKind = campaignKind;
        this.campaign = campaign;
        this.hotelNo = hotelNo;
    }

    public static CampaignSearchResponse of(Campaign campaign) {
        return CampaignSearchResponse.builder()
                .campaign(campaign)
                .campaignKind(campaign.getCampaignKind())
                .hotelNo(campaign.getHotelNo())
                .build();
    }
}
