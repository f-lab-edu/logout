package com.example.hotelproject.controller;

import com.example.hotelproject.config.TossPaymentConfig;
import com.example.hotelproject.controller.request.payment.PayCreateRequest;
import com.example.hotelproject.controller.response.payment.PaymentResponse;
import com.example.hotelproject.controller.response.payment.TossPaySuccessResponse;
import com.example.hotelproject.service.PaymentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    @ApiOperation(value = "결제 요청 검증", notes = "결제 요청에 필요한 값 반환")
    public PaymentResponse validatePayments(@RequestBody PayCreateRequest request){
        return paymentService.validatePayments(request);
    }

    @GetMapping("/toss/success")
    public TossPaySuccessResponse tossPaymentSuccess(
            @RequestParam String paymentKey,
            @RequestParam String orderId,
            @RequestParam Long amount
    ) {

        return paymentService.tossPaymentSuccess(paymentKey, orderId, amount);
    }
}
