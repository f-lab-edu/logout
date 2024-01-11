package com.example.hotelproject.dashboard.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "click_log")
public class ClickLog {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Id
    @CreatedDate
    @Column(name = "create_at")
    private LocalDateTime createAt;

    @Column(name = "hotel_no")
    private Long hotelNo;
    @Column(name = "room_no")
    private Long roomNo;
    @Column(name = "campaignKind_id")
    private Long campaignKindId;

    @Column(name = "inventory_id")
    private Long inventoryId;

}
