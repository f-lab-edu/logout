package com.example.hotelproject.campaign.entity;

import com.example.hotelproject.util.entity.BaseDateTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@NoArgsConstructor
@Entity
@Where(clause = "deleted = false")
public class Campaign extends BaseDateTimeEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "hotel_no")
    private Long hotelNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "campaign_type_id")
    private CampaignKind campaignKind;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "campaign_inventory_id")
    private CampaignInventory campaignInventory;

    @Column(name = "service_begin_date")
    private LocalDateTime serviceBeginDate;

    @Column(name = "service_end_date")
    private LocalDateTime serviceEndDate;

    @Column(name = "deleted")
    private boolean deleted = false;

    @Builder
    public Campaign(Long hotelNo, CampaignKind campaignKind, CampaignInventory campaignInventory, LocalDateTime serviceBeginDate, LocalDateTime serviceEndDate, boolean deleted) {
        this.hotelNo = hotelNo;
        this.campaignKind = campaignKind;
        this.campaignInventory = campaignInventory;
        this.serviceBeginDate = serviceBeginDate;
        this.serviceEndDate = serviceEndDate;
    }
}
