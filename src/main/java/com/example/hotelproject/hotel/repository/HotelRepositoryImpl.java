package com.example.hotelproject.hotel.repository;

import com.example.hotelproject.hotel.entity.Hotel;
import com.example.hotelproject.hotel.entity.HotelFilter;
import com.example.hotelproject.hotel.entity.HotelTypeEnum;
import com.example.hotelproject.hotel.entity.QHotel;
import com.example.hotelproject.hotel.entity.QHotelOption;
import com.example.hotelproject.reservation.entity.QReservation;
import com.example.hotelproject.room.entity.QRoom;
import com.querydsl.core.types.ConstantImpl;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.StringTemplate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public class HotelRepositoryImpl implements HotelCustomRepository {

    private final JPAQueryFactory queryFactory;

    public HotelRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    public static final QHotel hotel = new QHotel("hotel");
    public static final QRoom room = new QRoom("room");
    public static final QReservation reservation = new QReservation("reservation");
    private static final QHotelOption option = new QHotelOption("option");


    @Override
    public List<Hotel> searchHotelsBasic(Long cursorId, int limit,
            HotelFilter filter) {
        List<Hotel> hotels = queryFactory.selectFrom(hotel)
                .where(containsHotelName(filter.getHotelName())
//                        , eqHotelType(filter.getHotelType())
                        , eqLocation(filter.getLocation())
                        , eqGrade(filter.getGrade())
                        , ltId(cursorId)
                )
                .limit(limit
                        + 1) // limit 값으로 원래 불러올 게시글 개수보다 1개 더 불러와 다음에 호출할 게시글이 있는지를 판단
                .orderBy(hotel.hotelNo.asc())
                .fetch();

        boolean hasNext = false;
        if (hotels.size() > limit) {
            hotels.remove(limit);
            hasNext = true;
        }

        return hotels;
    }

    @Override
    public PageImpl<Hotel> sortingByScore(Pageable pageable, Hotel hotel) {
        return null;
    }

    //date formatting
    private StringTemplate formatDate(LocalDateTime dateTime) {
        StringTemplate formattedDate = Expressions.stringTemplate(
                "DATE_FORMAT({0}, {1})"
                , reservation.reservationStartDate
                , ConstantImpl.create("%Y-%m-%d"));
        return formattedDate;
    }

    @Override
    public PageImpl<Hotel> searchHotelsNew(Long lastId, Pageable pageable, Hotel hotelInfo,
            LocalDateTime startDate, LocalDateTime endDate) {
        return null;
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

    private BooleanExpression eqGrade(int grade) {
        return grade != 0 ? hotel.grade.eq(grade) : null;
    }

    // id < 첫 번째 조회에서는 파라미터를 사용하지 않기 위한 동적 쿼리
    private BooleanExpression ltId(Long cursorId) {
        if (cursorId == null) {
            return null;    // BooleanExpression 자리에 null이 반환되면 조건문에서 자동을 제외된다.
        }
        return hotel.hotelNo.lt(cursorId); // x.lt(y) = x<y
    }


}
