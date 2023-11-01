package com.example.hotelproject.reservation.entity;

import com.example.hotelproject.hotel.entity.Hotel;
import com.example.hotelproject.member.entity.Member;
import com.example.hotelproject.room.entity.Room;
import com.example.hotelproject.util.entity.BaseDateTimeEntity;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
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
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) //기본 생성자를 만들어줌
@ToString
@EntityListeners(AuditingEntityListener.class)
@Entity(name = "reservation")
public class Reservation extends BaseDateTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private Long reservationId;

    @Column(name = "reservation_start_date", nullable = false)
    private LocalDateTime reservationStartDate;

    @Column(name = "reservation_end_date", nullable = false)
    private LocalDateTime reservationEndDate;

    @Where(clause = "cancel_date is null") //TODO: canceledAt 으로 변경
    @Column(name = "cancel_date")
    private LocalDate cancelDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_no")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_no")
    private Hotel hotel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_no")
    private Room room;

    @Builder
    public Reservation(Long reservationId, LocalDateTime reservationStartDate,
            LocalDateTime reservationEndDate,
            LocalDate cancelDate,
            Member member, Hotel hotel, Room room) {
        this.reservationId = reservationId;
        this.reservationStartDate = reservationStartDate;
        this.reservationEndDate = reservationEndDate;
        this.cancelDate = cancelDate;
        this.member = member;
        this.hotel = hotel;
        this.room = room;
    }

    public boolean isDuplicatedDate(LocalDateTime startDate, LocalDateTime endDate) {
        return this.reservationStartDate.isBefore(endDate) && this.reservationEndDate
                .isAfter(startDate);
    }

    public void updateCancelDate() {
        this.cancelDate = LocalDate.now();
    }
}
