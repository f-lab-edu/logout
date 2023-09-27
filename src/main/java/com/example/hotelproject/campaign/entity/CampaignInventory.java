package com.example.hotelproject.campaign.entity;

import com.example.hotelproject.util.entity.BaseDateTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@NoArgsConstructor
@ToString
@Entity
public class CampaignInventory extends BaseDateTimeEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "inventory_key")
    private String inventoryKey;

    @Column(name = "display_name")
    private String displayName;

    @Builder
    public CampaignInventory(String inventoryKey, String displayName) {
        this.inventoryKey = inventoryKey;
        this.displayName = displayName;
    }
}
