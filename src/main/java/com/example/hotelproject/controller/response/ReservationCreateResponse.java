package com.example.hotelproject.controller.response;

import com.example.hotelproject.domain.Hotel;
import com.example.hotelproject.domain.Reservation;
import com.example.hotelproject.domain.User;
import java.util.Date;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class ReservationCreateResponse {

    private Long userNo;
    private Long hotelNo;
    private Long roomNo;
    private Date reservationStartDate;
    private Date reservationEndDate;
    private Date reservationDate;

    @Builder
    public ReservationCreateResponse(Long userNo, Long hotelNo, Long roomNo,
        Date reservationStartDate, Date reservationEndDate, Date reservationDate) {
        this.userNo = userNo;
        this.hotelNo = hotelNo;
        this.roomNo = roomNo;
        this.reservationStartDate = reservationStartDate;
        this.reservationEndDate = reservationEndDate;
        this.reservationDate = reservationDate;
    }

//    public static Reservation toReservation(User user, Hotel hotel, ReservationCreateResponse response){
//        return Reservation.builder()
//            .userNo(response.getUserNo())
//            .hotel_no(response.getHotelNo())
//            .reservation_start_date(response.getReservation_start_date())
//            .reservation_end_date(response.getReservation_end_date())
//            .reservation_date(response.getReservation_date())
//            .user(user)
//            .hotel(hotel)
//            .build();
//    }

    public ReservationCreateResponse fromReservation(Reservation reservation){
        return ReservationCreateResponse.builder()
            .userNo(userNo)
            .hotelNo(hotelNo)
            .roomNo(roomNo)
            .reservationDate(reservationDate)
            .reservationStartDate(reservationStartDate)
            .reservationEndDate(reservationEndDate)
            .build();
    }
}
