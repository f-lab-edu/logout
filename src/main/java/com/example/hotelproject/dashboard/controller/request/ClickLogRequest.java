package com.example.hotelproject.dashboard.controller.request;

import java.time.LocalDateTime;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ClickLogRequest {

    private Long userId;
    private LocalDateTime createAt;
    private Long hotelNo;
    private Long roomNo;
    private Long campaignKindId;
    private Long inventoryId;
}
