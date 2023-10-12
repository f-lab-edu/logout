package com.example.hotelproject.campaign.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCampaign is a Querydsl query type for Campaign
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCampaign extends EntityPathBase<Campaign> {

    private static final long serialVersionUID = -62575179L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCampaign campaign = new QCampaign("campaign");

    public final com.example.hotelproject.util.entity.QBaseDateTimeEntity _super = new com.example.hotelproject.util.entity.QBaseDateTimeEntity(this);

    public final QCampaignInventory campaignInventory;

    public final QCampaignKind campaignKind;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final BooleanPath deleted = createBoolean("deleted");

    public final BooleanPath expired = createBoolean("expired");

    public final com.example.hotelproject.hotel.entity.QHotel hotel;

    public final NumberPath<Long> hotelNo = createNumber("hotelNo", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final DateTimePath<java.time.LocalDateTime> serviceBeginDate = createDateTime("serviceBeginDate", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> serviceEndDate = createDateTime("serviceEndDate", java.time.LocalDateTime.class);

    public QCampaign(String variable) {
        this(Campaign.class, forVariable(variable), INITS);
    }

    public QCampaign(Path<? extends Campaign> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCampaign(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCampaign(PathMetadata metadata, PathInits inits) {
        this(Campaign.class, metadata, inits);
    }

    public QCampaign(Class<? extends Campaign> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.campaignInventory = inits.isInitialized("campaignInventory") ? new QCampaignInventory(forProperty("campaignInventory")) : null;
        this.campaignKind = inits.isInitialized("campaignKind") ? new QCampaignKind(forProperty("campaignKind")) : null;
        this.hotel = inits.isInitialized("hotel") ? new com.example.hotelproject.hotel.entity.QHotel(forProperty("hotel"), inits.get("hotel")) : null;
    }

}

