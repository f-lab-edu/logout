package com.example.hotelproject.payment.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPayment is a Querydsl query type for Payment
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPayment extends EntityPathBase<Payment> {

    private static final long serialVersionUID = -1043341957L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPayment payment = new QPayment("payment");

    public final com.example.hotelproject.util.entity.QBaseDateTimeEntity _super = new com.example.hotelproject.util.entity.QBaseDateTimeEntity(this);

    public final NumberPath<Long> amount = createNumber("amount", Long.class);

    public final StringPath cancelReason = createString("cancelReason");

    public final BooleanPath cancelYN = createBoolean("cancelYN");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final com.example.hotelproject.user.entity.QUser customer;

    public final StringPath failReason = createString("failReason");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final StringPath orderId = createString("orderId");

    public final StringPath orderName = createString("orderName");

    public final NumberPath<Long> paymentId = createNumber("paymentId", Long.class);

    public final StringPath paymentKey = createString("paymentKey");

    public final BooleanPath paySuccessYN = createBoolean("paySuccessYN");

    public final EnumPath<PayType> payType = createEnum("payType", PayType.class);

    public QPayment(String variable) {
        this(Payment.class, forVariable(variable), INITS);
    }

    public QPayment(Path<? extends Payment> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPayment(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPayment(PathMetadata metadata, PathInits inits) {
        this(Payment.class, metadata, inits);
    }

    public QPayment(Class<? extends Payment> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.customer = inits.isInitialized("customer") ? new com.example.hotelproject.user.entity.QUser(forProperty("customer")) : null;
    }

}

