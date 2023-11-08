package com.example.hotelproject.payment.entity;

import com.example.hotelproject.member.entity.Member;
import com.example.hotelproject.util.entity.BaseDateTimeEntity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor
@Setter
@Table(name = "payment")
public class Payment extends BaseDateTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id", nullable = false, unique = true)
    private Long paymentId;
    @Column(nullable = false, name = "pay_type")
    @Enumerated(EnumType.STRING)
    private PayType payType;
    @Column(nullable = false, name = "pay_amount")
    private Long amount;
    @Column(nullable = false, name = "pay_name")
    private String orderName;
    @Column(nullable = false, name = "order_id")
    private String orderId;

    private boolean paySuccessYN;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user")
    private Member customer;
    @Column
    private String paymentKey;
    @Column
    private String failReason;

    @Column
    private boolean cancelYN;
    @Column
    private String cancelReason;


    @Builder
    public Payment(Long paymentId, PayType payType, Long amount, String orderName, String orderId,
            boolean paySuccessYN, Member customer, String paymentKey, String failReason,
            boolean cancelYN, String cancelReason) {
        this.paymentId = paymentId;
        this.payType = payType;
        this.amount = amount;
        this.orderName = orderName;
        this.orderId = orderId;
        this.paySuccessYN = paySuccessYN;
        this.customer = customer;
        this.paymentKey = paymentKey;
        this.failReason = failReason;
        this.cancelYN = cancelYN;
        this.cancelReason = cancelReason;
    }
}