package com.example.hotelproject.hotel.controller.request;

import com.example.hotelproject.hotel.entity.Hotel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class HotelCreateRequest { // Swagger 쓰도록 변경해보죠 ~
    /*호텔이름*/
    private String hotelName;
    /*호텔타입*/
    private String hotelType;
    /*위치*/
    private String location;
    /*호텔등급*/
    private int grade;
    /*조식제공여부*/
    private boolean breakfastYn; // 이런 부가정보들은 추가로 많이 생길 수도 있을 것 같은데, 각각의 필드의 y,n으로 관리하면 유지보수가 어려워지지 않을까요 ~? 부가정보에 대한 enum을 만들어두고 그 리스트를 받으면 변경이 쉽지 않을까 해서 의견 남겨봅니다
    /*주차가능여부*/
    private boolean parkingYn;
    /*수영장여부*/
    private boolean swimYn;
    /*휘트니스 여부*/
    private boolean fitnessYn;
    private String checkin; // 요건 어떤 데이터를 담으려고 하신걸까요 ~?
    private String checkout;
    private String remrk; // 이건 뭐였죠? 얘기 했던거같은데, 변수명에 줄임말은 지양하는게 좋을 것 같습니다 ~

    @Builder // 혹시 save actions랑 구글컨벤션 적용 되어있을까요 ~? 아래 라인이 컨벤션 적용이 안된것 같아 여쭤봅니다 ~
    public HotelCreateRequest( String hotelName, String hotelType, String location, int grade, boolean breakfastYn, boolean parkingYn, boolean swimYn, boolean fitnessYn, String checkin, String checkout, String remrk) {
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
    }

    public Hotel toEntity(){
        return Hotel.builder()
            .hotelName(hotelName)
            .hotelType(hotelType)
            .location(location)
            .grade(grade)
            .breakfastYn(breakfastYn)
            .parkingYn(parkingYn)
            .swimYn(swimYn)
            .fitnessYn(fitnessYn)
            .checkin(checkin)
            .checkout(checkout)
            .remrk(remrk)
            .build();
    }
}
