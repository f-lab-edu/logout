package com.example.hotelproject.campaign.entity;

import com.example.hotelproject.util.entity.BaseDateTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@NoArgsConstructor
@ToString
@Entity
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
    private LocalDate salesBeginDate;

    @Column(name = "sales_end_date")
    private LocalDate salesEndDate;

    @Builder
    public CampaignKind(String kindKey, String displayName, CampaignBillingType billingType, BigDecimal price, LocalDate salesBeginDate, LocalDate salesEndDate) {
        this.kindKey = kindKey;
        this.displayName = displayName;
        this.billingType = billingType;
        this.price = price;
        this.salesBeginDate = salesBeginDate;
        this.salesEndDate = salesEndDate;
    }
}
