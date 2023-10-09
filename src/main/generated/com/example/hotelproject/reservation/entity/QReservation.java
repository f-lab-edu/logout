package com.example.hotelproject.reservation.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReservation is a Querydsl query type for Reservation
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReservation extends EntityPathBase<Reservation> {

    private static final long serialVersionUID = -1527403205L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReservation reservation = new QReservation("reservation");

    public final com.example.hotelproject.util.entity.QBaseDateTimeEntity _super = new com.example.hotelproject.util.entity.QBaseDateTimeEntity(this);

    public final DatePath<java.time.LocalDate> cancelDate = createDate("cancelDate", java.time.LocalDate.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final com.example.hotelproject.hotel.entity.QHotel hotel;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final DatePath<java.time.LocalDate> reservationEndDate = createDate("reservationEndDate", java.time.LocalDate.class);

    public final DatePath<java.time.LocalDate> reservationStartDate = createDate("reservationStartDate", java.time.LocalDate.class);

    public final com.example.hotelproject.room.entity.QRoom room;

    public final com.example.hotelproject.user.entity.QUser user;

    public QReservation(String variable) {
        this(Reservation.class, forVariable(variable), INITS);
    }

    public QReservation(Path<? extends Reservation> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReservation(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReservation(PathMetadata metadata, PathInits inits) {
        this(Reservation.class, metadata, inits);
    }

    public QReservation(Class<? extends Reservation> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.hotel = inits.isInitialized("hotel") ? new com.example.hotelproject.hotel.entity.QHotel(forProperty("hotel"), inits.get("hotel")) : null;
        this.room = inits.isInitialized("room") ? new com.example.hotelproject.room.entity.QRoom(forProperty("room"), inits.get("room")) : null;
        this.user = inits.isInitialized("user") ? new com.example.hotelproject.user.entity.QUser(forProperty("user")) : null;
    }

}

