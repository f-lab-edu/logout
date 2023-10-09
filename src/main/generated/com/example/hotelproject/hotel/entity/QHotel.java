package com.example.hotelproject.hotel.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QHotel is a Querydsl query type for Hotel
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QHotel extends EntityPathBase<Hotel> {

    private static final long serialVersionUID = -280744069L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QHotel hotel = new QHotel("hotel");

    public final com.example.hotelproject.util.entity.QBaseDateTimeEntity _super = new com.example.hotelproject.util.entity.QBaseDateTimeEntity(this);

    public final StringPath checkin = createString("checkin");

    public final StringPath checkout = createString("checkout");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Integer> grade = createNumber("grade", Integer.class);

    public final StringPath hotelName = createString("hotelName");

    public final NumberPath<Long> hotelNo = createNumber("hotelNo", Long.class);

    public final StringPath hotelType = createString("hotelType");

    public final StringPath location = createString("location");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final ListPath<HotelOption, QHotelOption> options = this.<HotelOption, QHotelOption>createList("options", HotelOption.class, QHotelOption.class, PathInits.DIRECT2);

    public final com.example.hotelproject.owner.entity.QOwner owner;

    public QHotel(String variable) {
        this(Hotel.class, forVariable(variable), INITS);
    }

    public QHotel(Path<? extends Hotel> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QHotel(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QHotel(PathMetadata metadata, PathInits inits) {
        this(Hotel.class, metadata, inits);
    }

    public QHotel(Class<? extends Hotel> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.owner = inits.isInitialized("owner") ? new com.example.hotelproject.owner.entity.QOwner(forProperty("owner")) : null;
    }

}

