package com.example.hotelproject.room.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRoomQuantity is a Querydsl query type for RoomQuantity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRoomQuantity extends EntityPathBase<RoomQuantity> {

    private static final long serialVersionUID = 1876744438L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRoomQuantity roomQuantity = new QRoomQuantity("roomQuantity");

    public final com.example.hotelproject.util.entity.QBaseDateTimeEntity _super = new com.example.hotelproject.util.entity.QBaseDateTimeEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final DatePath<java.time.LocalDate> date = createDate("date", java.time.LocalDate.class);

    public final com.example.hotelproject.hotel.entity.QHotel hotel;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final NumberPath<Integer> quantity = createNumber("quantity", Integer.class);

    public final QRoom room;

    public QRoomQuantity(String variable) {
        this(RoomQuantity.class, forVariable(variable), INITS);
    }

    public QRoomQuantity(Path<? extends RoomQuantity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRoomQuantity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRoomQuantity(PathMetadata metadata, PathInits inits) {
        this(RoomQuantity.class, metadata, inits);
    }

    public QRoomQuantity(Class<? extends RoomQuantity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.hotel = inits.isInitialized("hotel") ? new com.example.hotelproject.hotel.entity.QHotel(forProperty("hotel"), inits.get("hotel")) : null;
        this.room = inits.isInitialized("room") ? new QRoom(forProperty("room"), inits.get("room")) : null;
    }

}

