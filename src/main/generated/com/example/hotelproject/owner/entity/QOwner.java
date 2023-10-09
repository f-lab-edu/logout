package com.example.hotelproject.owner.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QOwner is a Querydsl query type for Owner
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QOwner extends EntityPathBase<Owner> {

    private static final long serialVersionUID = -692189733L;

    public static final QOwner owner = new QOwner("owner");

    public final com.example.hotelproject.util.entity.QBaseDateTimeEntity _super = new com.example.hotelproject.util.entity.QBaseDateTimeEntity(this);

    public final StringPath address = createString("address");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath email = createString("email");

    public final BooleanPath enabled = createBoolean("enabled");

    public final StringPath mobile = createString("mobile");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final StringPath name = createString("name");

    public final StringPath ownerId = createString("ownerId");

    public final NumberPath<Long> ownerNo = createNumber("ownerNo", Long.class);

    public final StringPath password = createString("password");

    public QOwner(String variable) {
        super(Owner.class, forVariable(variable));
    }

    public QOwner(Path<? extends Owner> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOwner(PathMetadata metadata) {
        super(Owner.class, metadata);
    }

}

