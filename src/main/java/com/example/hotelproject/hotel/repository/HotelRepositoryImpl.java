package com.example.hotelproject.hotel.repository;

import com.example.hotelproject.hotel.entity.Hotel;
import com.example.hotelproject.hotel.entity.HotelOption;
import com.example.hotelproject.hotel.entity.QHotel;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public class HotelRepositoryImpl implements HotelCustomRepository {

    private final JPAQueryFactory queryFactory;

    public HotelRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    public static final QHotel hotel = new QHotel("hotel");

    @Override
    public PageImpl<Hotel> searchHotels(Pageable pageable, Hotel filter) {
        List<Hotel> hotels = queryFactory.selectFrom(hotel)
                .where(containsHotelName(filter.getHotelName())
                        , eqHotelType(filter.getHotelType())
                        , eqLocation(filter.getLocation())
                        , eqGrade(filter.getGrade())
                                .or(hotel.options.contains((HotelOption) filter.getOptions()))
//TODO: test
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        Long count = queryFactory.select(hotel.count())
                .from(hotel)
                .where(containsHotelName(filter.getHotelName())
                        , eqHotelType(filter.getHotelType())
                        , eqLocation(filter.getLocation())
                        , eqGrade(filter.getGrade()))
                .fetchOne();

        return new PageImpl<>(hotels, pageable, count);
    }

    @Override
    public PageImpl<Hotel> sortingByScore(Pageable pageable, Hotel hotel) {
        return null;
    }


    private BooleanExpression containsHotelName(String name) {
        return name != null ? hotel.hotelName.contains(name) : null;
    }

    private BooleanExpression eqHotelType(String type) {
        return type != null ? hotel.hotelType.eq(type) : null;
    }

    private BooleanExpression eqLocation(String location) {
        return location != null ? hotel.location.eq(location) : null;
    }

    private BooleanExpression eqGrade(int grade) {
        return grade != 0 ? hotel.grade.eq(grade) : null;
    }


}
