package com.example.hotelproject.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Hotel {
    private int hotelNo;        /*호텔번호*/
    private String hotelName;     /*호텔이름*/
    private String hotelType;   /*호텔타입*/
    private String location;    /*위치*/
    private int grade;          /*호텔등급*/
    private boolean breakfastYn; /*조식제공여부*/
    private boolean parkingYn;      /*주차가능여부*/
    private boolean swimYn;      /*수영장여부*/
    private boolean fittnessYn;       /*휘트니스 여부*/
    private String chkin;       /*체크인*/
    private String chkout;      /*체크아웃*/
    private String remrk;       /*비고*/

    @Builder
    public Hotel(int hotelNo, String hotelName, String hotelType, String location, int grade, boolean breakfastYn, boolean parkingYn, boolean swimYn, boolean fittnessYn, String chkin, String chkout, String remrk) {
        this.hotelNo = hotelNo;
        this.hotelName = hotelName;
        this.hotelType = hotelType;
        this.location = location;
        this.grade = grade;
        this.breakfastYn = breakfastYn;
        this.parkingYn = parkingYn;
        this.swimYn = swimYn;
        this.fittnessYn = fittnessYn;
        this.chkin = chkin;
        this.chkout = chkout;
        this.remrk = remrk;
    }
}
