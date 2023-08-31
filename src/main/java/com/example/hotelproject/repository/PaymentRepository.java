package com.example.hotelproject.repository;

import com.example.hotelproject.domain.payment.Payment;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Optional<Payment> findByOrderId(String orderId);
    Optional<Payment> findByPaymentKeyAndCustomer_Email(String paymentKey, String email);
    List<Payment> findAllByCustomer_Email(String email);

}
