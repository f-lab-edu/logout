package com.example.hotelproject.hotel.entity;

import com.example.hotelproject.hotel.controller.request.HotelUpdateRequest;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.hotelproject.owner.entity.Owner;
import com.example.hotelproject.util.entity.BaseDateTimeEntity;
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
    private Long hotelNo;        /*호텔번호*/
    // 취향일수도 있는데, entity에는 필드에 대한 설명 빠져도 될 것 같아요, 테이블 생성 DDL 에 COMMENT 예약어로 필드 설명을 추가 해 둘 수 있습니다 ~

    @Column(name = "hotel_name", nullable = false)
    private String hotelName;     /*호텔이름*/

    @Column(name = "hotel_type")
    private String hotelType;   /*호텔타입*/

    @Column(name = "location")
    private String location;    /*위치*/

    @Column(name = "grade")
    private int grade;          /*호텔등급*/

    @Column(name = "breakfast_yn")
    private boolean breakfastYn; /*조식제공여부*/

    @Column(name = "parking_yn")
    private boolean parkingYn;      /*주차가능여부*/

    @Column(name = "swim_yn")
    private boolean swimYn;      /*수영장여부*/

    @Column(name = "fitness_yn")
    private boolean fitnessYn;       /*휘트니스 여부*/

    @Column(name = "check_in")
    private String checkin;       /*체크인*/

    @Column(name = "check_out")
    private String checkout;      /*체크아웃*/

    @Column(name = "remrk")
    private String remrk;       /*비고*/

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_no")
    private Owner owner;

    @Builder
    public Hotel(Long hotelNo, String hotelName, String hotelType, String location, int grade,
        boolean breakfastYn, boolean parkingYn, boolean swimYn, boolean fitnessYn,
        String checkin, String checkout, String remrk,
        Owner owner) {
        this.hotelNo = hotelNo;
        this.hotelName = hotelName;
        this.hotelType = hotelType;
        this.location = location;
        this.grade = grade;
        this.breakfastYn = breakfastYn;
        this.parkingYn = parkingYn;
        this.swimYn = swimYn;
        this.fitnessYn = fitnessYn;
        this.checkin = checkin;
        this.checkout = checkout;
        this.remrk = remrk;
        this.owner = owner;
    }

    // hotelNo는 안쓰이고 있네요 ~ 추가로, hotelNo는 이 테이블의 id인데 바꾸면 될까요 ?
    // HotelUpdateRequest를 참조하고 있는 것도 좋은 구조가 아닌 것 같습니다 ~
    public void update(Long hotelNo, HotelUpdateRequest request){
        this.hotelNo = getHotelNo();
        this.hotelName = request.getHotelName();
        this.hotelType = request.getHotelType();
        this.location = request.getLocation();
        this.breakfastYn = request.isBreakfastYn();
        this.swimYn = request.isSwimYn();
        this.fitnessYn = request.isFitnessYn();
        this.parkingYn = request.isParkingYn();
        this.checkin = request.getCheckin();
        this.checkout = request.getCheckout();
        this.remrk = request.getRemrk();

    }
}
