package com.example.hotelproject.campaign.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QCampaignKind is a Querydsl query type for CampaignKind
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCampaignKind extends EntityPathBase<CampaignKind> {

    private static final long serialVersionUID = -704578839L;

    public static final QCampaignKind campaignKind = new QCampaignKind("campaignKind");

    public final com.example.hotelproject.util.entity.QBaseDateTimeEntity _super = new com.example.hotelproject.util.entity.QBaseDateTimeEntity(this);

    public final EnumPath<CampaignBillingType> billingType = createEnum("billingType", CampaignBillingType.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath displayName = createString("displayName");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath kindKey = createString("kindKey");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final NumberPath<java.math.BigDecimal> price = createNumber("price", java.math.BigDecimal.class);

    public final DateTimePath<java.time.LocalDateTime> salesBeginDate = createDateTime("salesBeginDate", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> salesEndDate = createDateTime("salesEndDate", java.time.LocalDateTime.class);

    public QCampaignKind(String variable) {
        super(CampaignKind.class, forVariable(variable));
    }

    public QCampaignKind(Path<? extends CampaignKind> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCampaignKind(PathMetadata metadata) {
        super(CampaignKind.class, metadata);
    }

}

