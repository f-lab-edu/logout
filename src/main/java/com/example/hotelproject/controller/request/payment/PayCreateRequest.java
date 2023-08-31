package com.example.hotelproject.controller.request.payment;

import com.example.hotelproject.domain.User;
import com.example.hotelproject.domain.payment.PayType;
import com.example.hotelproject.domain.payment.Payment;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PayCreateRequest {

    @NonNull
    private PayType payType;
    @NonNull
    private Long amount;
    @NonNull
    private String orderName;

    private String customerEmail;
    private String customerName;

    private String yourSuccessUrl;
    private String yourFailUrl;

    @Builder
    public PayCreateRequest(@NonNull PayType payType, @NonNull Long amount, @NonNull String orderName, String customerEmail, String customerName, String yourSuccessUrl, String yourFailUrl) {
        this.payType = payType;
        this.amount = amount;
        this.orderName = orderName;
        this.customerEmail = customerEmail;
        this.customerName = customerName;
        this.yourSuccessUrl = yourSuccessUrl;
        this.yourFailUrl = yourFailUrl;
    }

    public Payment toEntity(User user) {
        return Payment.builder()
            .payType(payType)
            .amount(amount)
            .orderName(orderName)
            .orderId(UUID.randomUUID().toString())
            .customer(user)
            .paySuccessYN(false)
            .build();
    }
}
