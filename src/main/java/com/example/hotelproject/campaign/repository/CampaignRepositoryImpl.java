package com.example.hotelproject.campaign.repository;

import com.example.hotelproject.campaign.entity.Campaign;
import com.example.hotelproject.campaign.entity.QCampaign;
import com.example.hotelproject.campaign.entity.QCampaignInventory;
import com.example.hotelproject.campaign.entity.QCampaignKind;
import com.querydsl.core.types.ConstantImpl;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.CaseBuilder;
import com.querydsl.core.types.dsl.DateExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.NumberExpression;
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
    public List<Long> findPowerLinkCampaign(Long inventoryId, Long kindId) {
        return queryFactory.select(campaign.hotel.hotelNo)
                .from(campaign)
                .where(campaignInventory.id.eq(inventoryId)
                        .and(campaignKind.id.eq(kindId))
                        .and(campaign.expired.isFalse())
                        .and(campaign.deleted.isFalse())
                        .and(campaign.serviceEndDate.after(LocalDateTime.now())))
                .limit(2) // 파워링크는 상단에 2개만 노출
                .fetch();
    }

    @Override
    public List<Campaign> findSearchCampaign(Long inventoryId, List<String> kinds) {
        return queryFactory.select(campaign)
                .from(campaign)
                .innerJoin(campaign.campaignKind, campaignKind)
                .where(campaignKind.kindKey.in(kinds)
                        .and(campaign.expired.isFalse())
                        .and(campaign.deleted.isFalse())
                        .and(campaign.serviceEndDate.after(LocalDateTime.now())))
//                .orderBy(campaignKind.kindKey.eq("SEARCH").desc())
                .orderBy(new OrderSpecifier<>(Order.DESC, kindOrder("SEARCH")))
                .fetch();
    }

    private NumberExpression<Integer> kindOrder(String kindkey) {
        return new CaseBuilder()
                .when(campaignKind.kindKey.eq(kindkey))
                .then(1)
                .otherwise(0);
    }
}
