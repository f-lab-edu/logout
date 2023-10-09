package com.example.hotelproject.review.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReview is a Querydsl query type for Review
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReview extends EntityPathBase<Review> {

    private static final long serialVersionUID = 976777093L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReview review = new QReview("review");

    public final com.example.hotelproject.util.entity.QBaseDateTimeEntity _super = new com.example.hotelproject.util.entity.QBaseDateTimeEntity(this);

    public final StringPath contents = createString("contents");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final com.example.hotelproject.hotel.entity.QHotel hotel;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final NumberPath<Long> seq = createNumber("seq", Long.class);

    public final NumberPath<Integer> starRate = createNumber("starRate", Integer.class);

    public final com.example.hotelproject.user.entity.QUser user;

    public QReview(String variable) {
        this(Review.class, forVariable(variable), INITS);
    }

    public QReview(Path<? extends Review> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReview(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReview(PathMetadata metadata, PathInits inits) {
        this(Review.class, metadata, inits);
    }

    public QReview(Class<? extends Review> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.hotel = inits.isInitialized("hotel") ? new com.example.hotelproject.hotel.entity.QHotel(forProperty("hotel"), inits.get("hotel")) : null;
        this.user = inits.isInitialized("user") ? new com.example.hotelproject.user.entity.QUser(forProperty("user")) : null;
    }

}

