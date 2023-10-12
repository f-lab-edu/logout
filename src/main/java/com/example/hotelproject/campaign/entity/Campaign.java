package com.example.hotelproject.campaign.entity;

import static javax.persistence.GenerationType.IDENTITY;

import com.example.hotelproject.hotel.entity.Hotel;
import com.example.hotelproject.util.entity.BaseDateTimeEntity;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

@Getter
@NoArgsConstructor
@Entity(name = "campaign")
@Where(clause = "deleted = false")
public class Campaign extends BaseDateTimeEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Long id;

//    @Column(name = "hotel_no")
//    private Long hotelNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "campaign_kind_id")
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

    @Column(name = "expired")
    private boolean expired = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_no")
    private Hotel hotel;

    @Builder
    public Campaign(CampaignKind campaignKind, CampaignInventory campaignInventory,
            LocalDateTime serviceBeginDate, LocalDateTime serviceEndDate, boolean deleted,
            boolean expired, Hotel hotel) {
        this.campaignKind = campaignKind;
        this.campaignInventory = campaignInventory;
        this.serviceBeginDate = serviceBeginDate;
        this.serviceEndDate = serviceEndDate;
        this.hotel = hotel;
    }

    public void updateDelete(boolean deleted) {
        this.deleted = deleted;
    }

    public void updateExpire(boolean expired) {
        this.expired = expired;
    }
}
