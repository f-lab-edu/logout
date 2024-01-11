package com.example.hotelproject.dashboard.repository;

import com.example.hotelproject.dashboard.entity.QClickLog;
import com.example.hotelproject.hotel.entity.QHotel;
import com.example.hotelproject.member.entity.QMember;
import com.example.hotelproject.reservation.entity.QReservation;
import com.example.hotelproject.room.entity.QRoom;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.ConstantImpl;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.StringTemplate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class DashboardCustomImpl implements DashboardCustomRepository {

    private final JPAQueryFactory queryFactory;

    public DashboardCustomImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    public static final QClickLog clickLog = new QClickLog("clickLog");
    public static final QHotel hotel = new QHotel("hotel");
    public static final QRoom room = new QRoom("room");
    public static final QReservation reservation = new QReservation("reservation");


    StringTemplate formattedDateYm = Expressions.stringTemplate(
            "DATE_FORMAT({0}, {1})"
            , clickLog.createAt
            , ConstantImpl.create("%Y-%m"));


    LocalDateTime todayStart = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
    LocalDateTime todayEnd = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);

    @Override
    public List<Long> monthlyCountByInventoryId(Long inventoryId) {
        List<Long> result = queryFactory.select(clickLog.count())
                .from(clickLog)
                .where(clickLog.inventoryId.eq(inventoryId))
                .groupBy(formattedDateYm)
                .orderBy(formattedDateYm.desc())
                .fetch();

        return result;
    }

    @Override
    public Integer todaySales(Long hotelNo) {
        return queryFactory.select(reservation.room.price.sum())
                .from(reservation)
                .where(reservation.hotel.hotelNo.eq(hotelNo)
                        .and(reservation.cancelDate.isNull())
                        .and(reservation.createdAt.between(todayStart, todayEnd)))
                .fetchOne();
    }

    @Override
    public Integer monthlySales(Long hotelNo, String yearMonth) {
        return queryFactory.select(reservation.room.price.sum())
                .from(reservation)
                .where(reservation.hotel.hotelNo.eq(hotelNo)
                        .and(reservation.cancelDate.isNull())
                        .and(reservation.createdAt.year().eq(
                                Integer.valueOf(yearMonth.substring(5, 6)))
                        )
                )
                .fetchOne();
    }

    ///TODO: test 필요
    @Override
    public List<Tuple> campaignClicksByAge(Long campaignId) {
        return queryFactory.select(QMember.member.age, clickLog.count())
                .from(clickLog)
                .innerJoin(QMember.member)
                .where(clickLog.userId.eq(QMember.member.memberId))
                .groupBy(QMember.member.age)
                .fetch();
    }
}
