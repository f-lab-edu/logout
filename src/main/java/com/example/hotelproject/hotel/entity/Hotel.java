package com.example.hotelproject.hotel.entity;

import com.example.hotelproject.owner.entity.Owner;
import com.example.hotelproject.util.entity.BaseDateTimeEntity;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

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

    @OneToMany
    private List<HotelOption> options; // BREAKFAST, SMOKE

    @Builder
    public Hotel(Long hotelNo, String hotelName, String hotelType, String location, int grade,
            boolean breakfastYn, boolean parkingYn, boolean swimYn, boolean fitnessYn,
            String checkin, String checkout, String remrk, List<HotelOption> options,
            Owner owner) {
        this.hotelNo = hotelNo;
        this.hotelName = hotelName;
        this.hotelType = hotelType;
        this.location = location;
        this.grade = grade;
        this.checkin = checkin;
        this.checkout = checkout;
        this.owner = owner;
        this.options = options;
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
}
