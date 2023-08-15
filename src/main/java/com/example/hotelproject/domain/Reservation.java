package com.example.hotelproject.domain;

import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
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

@Getter
@Builder
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

    @Column(name = "reservation_start_date")
    private Date reservationStartDate;

    @Column(name = "reservation_end_date", nullable = false)
    private Date reservationEndDate;

    @Column(name = "reservation_date")
    private LocalDateTime reservationDate;

    @Column(name = "cancel_date")
    private Date cancelDate;

    @ManyToOne
    @JoinColumn(name = "user_no", insertable = false, updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "hotel_no", insertable = false, updatable = false)
    private Hotel hotel;

    public Reservation(Long id, Long userNo, Long hotelNo, Date reservationStartDate,
        Date reservationEndDate, LocalDateTime reservationDate, Date cancelDate,
        User user, Hotel hotel) {
        this.id = id;
        this.userNo = userNo;
        this.hotelNo = hotelNo;
        this.reservationStartDate = reservationStartDate;
        this.reservationEndDate = reservationEndDate;
        this.reservationDate = reservationDate;
        this.cancelDate = cancelDate;
        this.user = user;
        this.hotel = hotel;
    }
}
