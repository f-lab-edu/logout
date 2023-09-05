package com.example.hotelproject.payment.controller.response;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class TossPaySuccessResponse {
    String mid;
    String version;
    String paymentKey;
    String orderId;
    String orderName;
    String currency;
    String method;
    String totalAmount;
    String balanceAmount;
    String suppliedAmount;
    String vat;
    String status;
    String requestedAt;
    String approvedAt;
    String useEscrow;
    String cultureExpense;
    String type;
}
