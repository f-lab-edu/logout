package com.example.hotelproject.payment.service;

import com.example.hotelproject.config.TossPaymentConfig;
import com.example.hotelproject.payment.controller.request.PayCreateRequest;
import com.example.hotelproject.payment.controller.response.PaymentResponse;
import com.example.hotelproject.payment.controller.response.TossPaySuccessResponse;
import com.example.hotelproject.user.entity.User;
import com.example.hotelproject.payment.entity.Payment;
import com.example.hotelproject.payment.repository.PaymentRepository;
import com.example.hotelproject.user.repository.UserRepository;
import org.json.simple.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Collections;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final TossPaymentConfig tossPaymentConfig;
    private final UserRepository userRepository;

    public PaymentService(PaymentRepository paymentRepository, TossPaymentConfig tossPaymentConfig, UserRepository userRepository) {
        this.paymentRepository = paymentRepository;
        this.tossPaymentConfig = tossPaymentConfig;
        this.userRepository = userRepository;
    }

    @Transactional
    public PaymentResponse validatePayments(PayCreateRequest request) {
        Long amount = request.getAmount();
        String payType = request.getPayType().name();
        String customerEmail = request.getCustomerEmail();

        if (amount == null || amount != 100) {
            throw new RuntimeException("error order price");
        }

        if (!payType.equals("CARD") && !payType.equals("카드")) {
            throw new RuntimeException("error paymentType");
        }

        try {
            User user = userRepository.findByEmail(customerEmail).orElseThrow(() -> {throw new RuntimeException("user not found");});
            Payment payment = request.toEntity(user);
            paymentRepository.save(payment);

            PaymentResponse response = PaymentResponse.of(payment);
            response.updateUrl(tossPaymentConfig.getSuccessUrl(), tossPaymentConfig.getFailUrl());
            return response;
        } catch (Exception e) {
            throw new IllegalArgumentException("검증 실패");
        }
    }

    @Transactional
    public TossPaySuccessResponse tossPaymentSuccess(String paymentKey, String orderId, Long amount) {
        Payment payment = verifyPayment(orderId, amount);

        TossPaySuccessResponse result = requestPaymentAccept(paymentKey, orderId, amount);

        payment.setPaymentKey(paymentKey);//추후 결제 취소 / 결제 조회
        payment.setPaySuccessYN(true);

        return result;
    }
    public Payment verifyPayment(String orderId, Long amount) {
        Payment payment = paymentRepository.findByOrderId(orderId).orElseThrow(() -> {
            throw new IllegalArgumentException("PAYMENT_NOT_FOUND");
        });
        if (!payment.getAmount().equals(amount)) {
            throw new IllegalArgumentException("PAYMENT_AMOUNT_EXP");
        }
        return payment;
    }

    @Transactional
    private TossPaySuccessResponse requestPaymentAccept(String paymentKey, String orderId, Long amount) {
        RestTemplate rest=new RestTemplate();
        HttpHeaders headers=new HttpHeaders();

        String testSecretApiKey = tossPaymentConfig.getTestSecretApiKey() + ":";
        String encodedAuth=new String(Base64.getEncoder().encode(testSecretApiKey.getBytes(StandardCharsets.UTF_8)));

        headers.setBasicAuth(encodedAuth);
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        JSONObject param = new JSONObject();
        param.put("orderId", orderId);
        param.put("amount", amount);

        return rest.postForEntity(
                "http://localhost:8080/" + paymentKey,
                new HttpEntity<>(param, headers),
                TossPaySuccessResponse.class
        ).getBody();
    }

}
