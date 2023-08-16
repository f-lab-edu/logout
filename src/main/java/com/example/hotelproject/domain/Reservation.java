package com.example.hotelproject.domain;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.ibatis.annotations.Many;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) //기본 생성자를 만들어줌
@ToString
@Entity(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_no", nullable = false)
    private Long userNo;

    @Column(name = "hotel_no", nullable = false)
    private Long hotelNo;

    @Column(name = "room_no")
    private Long roomNo;

    @Column(name = "reservation_start_date")
    private LocalDate reservationStartDate;

    @Column(name = "reservation_end_date", nullable = false)
    private LocalDate reservationEndDate;

    @Column(name = "reservation_date")
    private LocalDateTime reservationDate;

    @Column(name = "cancel_date")
    private Date cancelDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_no", insertable = false, updatable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_no", insertable = false, updatable = false)
    private Hotel hotel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_no", insertable = false, updatable = false)
    private Room room;


    @Builder
    public Reservation(Long userNo, Long hotelNo, Long roomNo, LocalDate reservationStartDate,
        LocalDate reservationEndDate, LocalDateTime reservationDate, Date cancelDate,
        User user, Hotel hotel, Room room) {
        this.userNo = userNo;
        this.hotelNo = hotelNo;
        this.roomNo = roomNo;
        this.reservationStartDate = reservationStartDate;
        this.reservationEndDate = reservationEndDate;
        this.reservationDate = reservationDate;
        this.cancelDate = cancelDate;
        this.user = user;
        this.hotel = hotel;
        this.room = room;
    }
}
