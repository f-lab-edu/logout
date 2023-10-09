package com.example.hotelproject.hotel.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QHotelOption is a Querydsl query type for HotelOption
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QHotelOption extends EntityPathBase<HotelOption> {

    private static final long serialVersionUID = -1460479024L;

    public static final QHotelOption hotelOption = new QHotelOption("hotelOption");

    public final StringPath code = createString("code");

    public final StringPath description = createString("description");

    public QHotelOption(String variable) {
        super(HotelOption.class, forVariable(variable));
    }

    public QHotelOption(Path<? extends HotelOption> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHotelOption(PathMetadata metadata) {
        super(HotelOption.class, metadata);
    }

}

