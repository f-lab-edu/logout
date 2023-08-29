package com.example.hotelproject.domain;

import com.example.hotelproject.domain.room.Room;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Convert;
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
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters.LocalDateTimeConverter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) //기본 생성자를 만들어줌
@ToString
@EntityListeners(AuditingEntityListener.class)
@Entity(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private Long id;

    @Column(name = "reservation_start_date", nullable = false)
    private LocalDate reservationStartDate;

    @Column(name = "reservation_end_date", nullable = false)
    private LocalDate reservationEndDate;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "modified_at")
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime modifiedAt;

    @Column(name = "cancel_date")
    private LocalDate cancelDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_no")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "HOTEL_NO")
    private Hotel hotel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_no")
    private Room room;

    @Builder
    public Reservation(Long id, LocalDate reservationStartDate, LocalDate reservationEndDate,
        LocalDateTime createdAt, LocalDateTime modifiedAt, LocalDate cancelDate,
        User user, Hotel hotel, Room room) {
        this.id = id;
        this.reservationStartDate = reservationStartDate;
        this.reservationEndDate = reservationEndDate;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.cancelDate = cancelDate;
        this.user = user;
        this.hotel = hotel;
        this.room = room;
    }

    public boolean isDuplicatedDate(LocalDate startDate, LocalDate endDate){
        return this.reservationStartDate.isBefore(endDate) && this.reservationEndDate
            .isAfter(startDate);
    }

    public void updateCancelDate(){
        this.cancelDate = LocalDate.now();
    }
}
