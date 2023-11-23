package com.example.hotelproject.campaign.entity;

import static javax.persistence.GenerationType.IDENTITY;

import com.example.hotelproject.util.entity.BaseDateTimeEntity;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
@Entity(name = "campaign_kind")
public class CampaignKind extends BaseDateTimeEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "kind_key")
    private String kindKey;

    @Column(name = "display_name")
    private String displayName;

    @Enumerated(EnumType.STRING)
    @Column(name = "billing_type")
    private CampaignBillingType billingType;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "sales_begin_date")
    private LocalDateTime salesBeginDate;

    @Column(name = "sales_end_date")
    private LocalDateTime salesEndDate;

    @Builder
    public CampaignKind(String kindKey, String displayName, CampaignBillingType billingType,
            BigDecimal price, LocalDateTime salesBeginDate, LocalDateTime salesEndDate) {
        this.kindKey = kindKey;
        this.displayName = displayName;
        this.billingType = billingType;
        this.price = price;
        this.salesBeginDate = salesBeginDate;
        this.salesEndDate = salesEndDate;
    }
}
