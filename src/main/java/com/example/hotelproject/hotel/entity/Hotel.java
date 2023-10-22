package com.example.hotelproject.hotel.entity;

import com.example.hotelproject.owner.entity.Owner;
import com.example.hotelproject.util.entity.BaseDateTimeEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) //기본 생성자를 만들어줌
@ToString
@Entity(name = "hotel")
public class Hotel extends BaseDateTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotel_no")
    private Long hotelNo;

    @Column(name = "hotel_name", nullable = false)
    private String hotelName;

    @Column(name = "hotel_type") //TODO: enum으로 변경 예정
    private String hotelType;

    @Column(name = "location")
    private String location;

    @Column(name = "grade")
    private int grade;

    @Column(name = "check_in")
    private String checkin;

    @Column(name = "check_out")
    private String checkout;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_no")
    private Owner owner;

    @ManyToMany
    private List<HotelOption>  options; // BREAKFAST, SMOKE

    @Column(name = "star_rate_average")
    private float starRateAverage; //리뷰 평점

    @Builder
    public Hotel(Long hotelNo, String hotelName, String hotelType, String location, int grade,
            String checkin, String checkout, String remrk, List<HotelOption> options,
            Owner owner, float starRateAverage) {
        this.hotelNo = hotelNo;
        this.hotelName = hotelName;
        this.hotelType = hotelType;
        this.location = location;
        this.grade = grade;
        this.checkin = checkin;
        this.checkout = checkout;
        this.owner = owner;
        this.options = options;
        this.starRateAverage = starRateAverage;
    }

    public void update(String hotelName, String hotelType, String location, int grade,
            String checkin, String checkout, List<HotelOption> options) {
        this.hotelName = hotelName;
        this.hotelType = hotelType;
        this.location = location;
        this.grade = grade;
        this.checkin = checkin;
        this.checkout = checkout;
        this.options = options;
    }

    public void updateStarRateAverage(float starRateAverage) {
        this.starRateAverage = starRateAverage;
    }
}
