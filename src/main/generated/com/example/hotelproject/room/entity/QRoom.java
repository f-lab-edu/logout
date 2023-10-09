package com.example.hotelproject.room.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRoom is a Querydsl query type for Room
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRoom extends EntityPathBase<Room> {

    private static final long serialVersionUID = -397898933L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRoom room = new QRoom("room");

    public final com.example.hotelproject.util.entity.QBaseDateTimeEntity _super = new com.example.hotelproject.util.entity.QBaseDateTimeEntity(this);

    public final NumberPath<Integer> basicOccupancy = createNumber("basicOccupancy", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final com.example.hotelproject.hotel.entity.QHotel hotel;

    public final NumberPath<Integer> maximumOccupancy = createNumber("maximumOccupancy", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final NumberPath<Integer> price = createNumber("price", Integer.class);

    public final StringPath remrk = createString("remrk");

    public final EnumPath<RoomLevel> roomLevel = createEnum("roomLevel", RoomLevel.class);

    public final NumberPath<Long> roomNo = createNumber("roomNo", Long.class);

    public final EnumPath<RoomType> roomType = createEnum("roomType", RoomType.class);

    public final BooleanPath smokingYn = createBoolean("smokingYn");

    public QRoom(String variable) {
        this(Room.class, forVariable(variable), INITS);
    }

    public QRoom(Path<? extends Room> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRoom(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRoom(PathMetadata metadata, PathInits inits) {
        this(Room.class, metadata, inits);
    }

    public QRoom(Class<? extends Room> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.hotel = inits.isInitialized("hotel") ? new com.example.hotelproject.hotel.entity.QHotel(forProperty("hotel"), inits.get("hotel")) : null;
    }

}

