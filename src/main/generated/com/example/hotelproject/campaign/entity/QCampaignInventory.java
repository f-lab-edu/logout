package com.example.hotelproject.campaign.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QCampaignInventory is a Querydsl query type for CampaignInventory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCampaignInventory extends EntityPathBase<CampaignInventory> {

    private static final long serialVersionUID = -1590909145L;

    public static final QCampaignInventory campaignInventory = new QCampaignInventory("campaignInventory");

    public final com.example.hotelproject.util.entity.QBaseDateTimeEntity _super = new com.example.hotelproject.util.entity.QBaseDateTimeEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final StringPath name = createString("name");

    public QCampaignInventory(String variable) {
        super(CampaignInventory.class, forVariable(variable));
    }

    public QCampaignInventory(Path<? extends CampaignInventory> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCampaignInventory(PathMetadata metadata) {
        super(CampaignInventory.class, metadata);
    }

}

