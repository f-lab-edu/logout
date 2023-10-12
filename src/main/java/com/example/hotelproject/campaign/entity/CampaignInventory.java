package com.example.hotelproject.campaign.entity;

import static javax.persistence.GenerationType.IDENTITY;

import com.example.hotelproject.util.entity.BaseDateTimeEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
@Entity(name = "campaign_inventory")
public class CampaignInventory extends BaseDateTimeEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Builder
    public CampaignInventory(String name) {
        this.name = name;
    }
}
