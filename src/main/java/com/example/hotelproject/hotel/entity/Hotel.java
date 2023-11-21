package com.example.hotelproject.hotel.entity;

import com.example.hotelproject.util.entity.BaseDateTimeEntity;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    @Enumerated(EnumType.STRING)
    private HotelTypeEnum hotelType;

    @Column(name = "location")
    private String location;

    @Column(name = "grade")
    private int grade;

    @Column(name = "check_in")
    private String checkin;

    @Column(name = "check_out")
    private String checkout;

    @OneToMany(mappedBy = "hotel")
    private List<HotelOptions> hotelOptions; // BREAKFAST, SMOKE

//    @ElementCollection
//    @CollectionTable(name = "hotel_options", joinColumns = @JoinColumn(name = "hotelNo"))
//    @Column(name = "option")
//    private String options = new ArrayList<>();
//
//    @Column(name = "option")
//    private String option;

    @Column(name = "star_rate_average")
    private Double starRateAverage; //리뷰 평점

    @Builder
    public Hotel(Long hotelNo, String hotelName, HotelTypeEnum hotelType, String location,
            int grade,
            String checkin, String checkout,
            double starRateAverage) {
        this.hotelNo = hotelNo;
        this.hotelName = hotelName;
        this.hotelType = hotelType;
        this.location = location;
        this.grade = grade;
        this.checkin = checkin;
        this.checkout = checkout;
//        this.option = options;
        this.starRateAverage = starRateAverage;
    }

    public void update(String hotelName, HotelTypeEnum hotelType, String location, int grade,
            String checkin, String checkout) {
        this.hotelName = hotelName;
        this.hotelType = hotelType;
        this.location = location;
        this.grade = grade;
        this.checkin = checkin;
        this.checkout = checkout;
//        this.option = options;
    }

    public void updateStarRateAverage(double starRateAverage) {
        this.starRateAverage = starRateAverage;
    }
}
