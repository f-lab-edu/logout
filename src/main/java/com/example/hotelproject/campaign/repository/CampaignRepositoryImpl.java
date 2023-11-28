package com.example.hotelproject.campaign.repository;

import com.example.hotelproject.campaign.entity.Campaign;
import com.example.hotelproject.campaign.entity.QCampaign;
import com.example.hotelproject.campaign.entity.QCampaignInventory;
import com.example.hotelproject.campaign.entity.QCampaignKind;
import com.querydsl.core.types.ConstantImpl;
import com.querydsl.core.types.dsl.DateExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.StringTemplate;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.time.LocalDateTime;
import java.util.List;

public class CampaignRepositoryImpl implements CampaignCustomRepository {

    private final JPAQueryFactory queryFactory;

    public CampaignRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    public static final QCampaign campaign = new QCampaign("campaign");
    public static final QCampaignKind campaignKind = new QCampaignKind("campaignKind");
    public static final QCampaignInventory campaignInventory = new QCampaignInventory(
            "campaignInventory");


    StringTemplate formatEndDate = Expressions.stringTemplate("DATE_FORMAT({0},{1})"
            , campaignKind.salesEndDate
            , ConstantImpl.create("&Y-%m-%d"));

    StringTemplate formatBeginDate = Expressions.stringTemplate("DATE_FORMAT({0},{1})"
            , campaignKind.salesBeginDate
            , ConstantImpl.create("&Y-%m-%d"));

    StringTemplate formatTodayDate = Expressions.stringTemplate("DATE_FORMAT({0},{1})"
            , DateExpression.currentDate()
            , ConstantImpl.create("&Y-%m-%d"));

    //TODO: test
    @Override
    public List<Campaign> findMatchingWithCampaignKind() {

        return queryFactory.selectFrom(campaign)
                .where(campaign.serviceEndDate.eq(
                        JPAExpressions.select(campaignKind.salesEndDate)
                                .from(campaignKind)
                                .where(formatEndDate.eq(formatTodayDate))
                ))
                .fetch();
    }

    @Override
    public List<Campaign> findWithCampaignInventoryIdAndKindId(Long inventoryId, Long kindId) {

        return null;
//        return queryFactory.selectFrom(campaign)
//                .join(QHotel.hotel.hotelNo)
//                .where(campaign.hotel.hotelNo.eq(QHotel.hotel.hotelNo)
//                        .and(campaign.id.eq(inventoryId))
//                        .and(campaign.campaignKind.id.eq(kindId))
//                        .and(campaign.deleted.isFalse())
//                        .and(campaign.expired.isFalse())
//                        .and(formatEndDate.between(formatBeginDate, formatTodayDate))
//                )
//                .fetch();
    }

    @Override
    public List<Long> findPowerLinkCampaign(Long inventoryId, Long kindId) {
        return queryFactory.select(campaign.hotelNo)
                .from(campaign)
                .where(campaignInventory.id.eq(inventoryId)
                        .and(campaignKind.id.eq(kindId))
                        .and(campaign.expired.isFalse())
                        .and(campaign.deleted.isFalse())
                        .and(campaign.serviceEndDate.before(LocalDateTime.now())))
                .limit(2) // 파워링크는 상단에 2개만 노출
                .fetch();
    }

    @Override
    public List<Long> findSearchCampaign(Long inventoryId, Long kindId) {
        return queryFactory.select(campaign.hotelNo)
                .from(campaign)
                .innerJoin(campaign.campaignKind, campaignKind)
                .where(campaignInventory.id.eq(inventoryId)
                        .and(campaignKind.id.eq(kindId))
                        .and(campaign.expired.isFalse())
                        .and(campaign.deleted.isFalse())
                        .and(campaign.serviceEndDate.before(LocalDateTime.now())))
                .fetch();
    }
}
