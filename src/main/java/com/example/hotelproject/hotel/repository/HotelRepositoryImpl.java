package com.example.hotelproject.hotel.repository;

import static com.example.hotelproject.hotel.entity.QHotelOptions.hotelOptions;

import com.example.hotelproject.hotel.entity.Hotel;
import com.example.hotelproject.hotel.entity.HotelFilter;
import com.example.hotelproject.hotel.entity.HotelTypeEnum;
import com.example.hotelproject.hotel.entity.QHotel;
import com.example.hotelproject.hotel.entity.QHotelOption;
import com.example.hotelproject.reservation.entity.QReservation;
import com.example.hotelproject.room.entity.QRoom;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import java.util.stream.Collectors;

public class HotelRepositoryImpl implements HotelCustomRepository {

    private final JPAQueryFactory queryFactory;

    public HotelRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    public static final QHotel hotel = new QHotel("hotel");
    public static final QRoom room = new QRoom("room");
    public static final QReservation reservation = new QReservation("reservation");
    private static final QHotelOption option = new QHotelOption("option");


    //기본순
    @Override
    public List<Hotel> searchHotelsBasic(Long cursorId, int limit,
            HotelFilter filter) {
        List<Hotel> hotels = queryFactory.selectFrom(hotel)
                .where(containsHotelName(filter.getHotelName())
                        , eqLocation(filter.getLocation())
                        , goeGrade(filter.getGrade())
                        , goeStarRate(filter.getStarRateAverage())
                        , ltId(cursorId)
                )
                .limit(limit
                        + 1) // limit 값으로 원래 불러올 게시글 개수보다 1개 더 불러와 다음에 호출할 게시글이 있는지를 판단 //todo: 수정
                .orderBy(hotel.hotelNo.asc())
                .fetch();

        List<Hotel> hotelOptionList = findAllByOptions(filter.getOptionCode());

        //option 으로 걸러진 호텔 exist 체크
        List<Hotel> hotelList = hotels.stream().filter(hotel -> hotelOptionList.stream()
                        .anyMatch(hotelOption -> hotel.getHotelNo().equals(hotelOption.getHotelNo())))
                .collect(Collectors.toList());

        return hotelList;
    }

    @Override
    public List<Hotel> sortingByScore(Long cursorId, int limit, HotelFilter filter) {
        return null;
    }

    @Override
    public List<Hotel> findAllByOptions(List<String> optionCode) {
        return queryFactory.selectFrom(hotel)
                .innerJoin(hotel.hotelOptions, hotelOptions)
                .where(hotelOptions.hotelOption.code.in(optionCode))
                .groupBy(hotel.hotelNo)
                .having(hotel.hotelNo.count().eq(Long.valueOf(optionCode.size())))
                .fetch();
    }

    @Override
    public List<Hotel> findAllByHotelNo(List<Long> hotelNoList, Long cursorId, int limit) {
        return queryFactory.selectFrom(hotel)
                .where(hotel.hotelNo.in(hotelNoList)
                        .and(ltId(cursorId))
                )
                .limit(limit
                        + 1)
                .orderBy(hotel.hotelNo.asc())
                .fetch();
    }


    private BooleanExpression containsHotelName(String name) {
        return name != null ? hotel.hotelName.contains(name) : null;
    }

    private BooleanExpression eqHotelType(String type) {
        return type != null ? hotel.hotelType.eq(HotelTypeEnum.valueOf(type)) : null;
    }

    private BooleanExpression eqLocation(String location) {
        return location != null ? hotel.location.eq(location) : null;
    }

    private BooleanExpression goeGrade(int grade) {
        return grade != 0 ? hotel.grade.goe(grade) : null;
    }

    private BooleanExpression goeStarRate(double starRate) {
        return starRate != 0.0 ? hotel.grade.goe(starRate) : null;
    }

    // id < 첫 번째 조회에서는 파라미터를 사용하지 않기 위한 동적 쿼리
    private BooleanExpression ltId(Long cursorId) {
        if (cursorId == null) {
            return null;
        }
        return hotel.hotelNo.lt(cursorId); // x.lt(y) = x<y
    }


}
