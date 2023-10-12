package com.example.hotelproject.campaign.controller.request;

import com.example.hotelproject.campaign.entity.Campaign;
import com.example.hotelproject.campaign.entity.CampaignKind;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CampaignRegistRequest {

    private Long hotelNo;
    private Long campaignKindId;
    private LocalDateTime beginDate;
    private LocalDateTime endDate;

    @Builder
    public CampaignRegistRequest(Long hotelNo, Long campaignKindId, LocalDateTime beginDate,
            LocalDateTime endDate) {
        this.hotelNo = hotelNo;
        this.campaignKindId = campaignKindId;
        this.beginDate = beginDate;
        this.endDate = endDate;
    }

    public Campaign toCampaign(CampaignKind campaignKind) {
        return Campaign.builder()
                .hotelNo(hotelNo)
                .campaignKind(campaignKind)
                .serviceBeginDate(beginDate)
                .serviceEndDate(endDate)
                .build();
    }
}