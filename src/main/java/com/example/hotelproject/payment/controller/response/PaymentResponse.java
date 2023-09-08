package com.example.hotelproject.payment.controller.response;

import com.example.hotelproject.payment.entity.Payment;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PaymentResponse {
    private String payType;
    private Long amount;
    private String orderName;
    private String orderId;
    private String customerEmail;
    private String customerName;
    private String successUrl;
    private String failUrl;

    private String failReason;
    private boolean cancelYN;
    private String cancelReason;
    private String createdAt;
    private String paySuccessYn;
    @Builder
    public PaymentResponse(String payType, Long amount, String orderName, String orderId, String customerEmail,
                                String customerName, String successUrl, String failUrl, String failReason, boolean cancelYN, String cancelReason, String createdAt, String paySuccessYn) {
        this.payType = payType;
        this.amount = amount;
        this.orderName = orderName;
        this.orderId = orderId;
        this.customerEmail = customerEmail;
        this.customerName = customerName;
        this.successUrl = successUrl;
        this.failUrl = failUrl;
        this.failReason = failReason;
        this.cancelYN = cancelYN;
        this.cancelReason = cancelReason;
        this.createdAt = createdAt;
        this.paySuccessYn = paySuccessYn;
    }

    public void updateUrl(String successUrl, String failUrl){
        this.successUrl = successUrl;
        this.failUrl = failUrl;
    }

    public static PaymentResponse of(Payment payment){
        return PaymentResponse.builder()
                .payType(payment.getPayType().name())
                .amount(payment.getAmount())
                .orderName(payment.getOrderName())
                .orderId(payment.getOrderId())
                .customerEmail(payment.getCustomer().getEmail())
                .customerName(payment.getCustomer().getName())
                .createdAt(String.valueOf(payment.getCreatedAt()))
                .cancelYN(payment.isCancelYN())
                .failReason(payment.getFailReason())
                .build();
    }
}
