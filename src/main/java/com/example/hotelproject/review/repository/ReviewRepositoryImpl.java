package com.example.hotelproject.review.repository;

import com.example.hotelproject.review.entity.QReview;
import com.example.hotelproject.review.entity.Review;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class ReviewRepositoryImpl implements ReviewCustomRepository{

    private final JPAQueryFactory queryFactory;

    public ReviewRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    public static final QReview review = new QReview("review");

    @Override
    public PageImpl<Review> findAllContents(Pageable pageable, Long hotelNo) {
        List<Review> reviews = queryFactory.selectFrom(review)
                .where(eqHotelNo(hotelNo))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        Long count = queryFactory.select(review.count())
                .from(review)
                .where(eqHotelNo(hotelNo))
                .fetchOne();

        return new PageImpl<>(reviews, pageable, count);

    }

    private BooleanExpression eqHotelNo(Long hotelNo){
        return hotelNo != null ? review.hotel.hotelNo.eq(hotelNo) : null;
    }
}
