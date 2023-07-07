package com.example.hotelproject.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Hotel {
    private int hotelNo;        /*호텔번호*/
    private String hotelNm;     /*호텔이름*/
    private String hotelType;   /*호텔타입*/
    private String location;    /*위치*/
    private int grade;          /*호텔등급*/
    private String breakfastYn; /*조식제공여부*/
    private String parkYn;      /*주차가능여부*/
    private String swimYn;      /*수영장여부*/
    private String fitYn;       /*휘트니스 여부*/
    private String chkin;       /*체크인*/
    private String chkout;      /*체크아웃*/
    private String remrk;       /*비고*/

    @Builder
    public Hotel(int hotelNo, String hotelNm, String hotelType, String location, int grade, String breakfastYn, String parkYn, String swimYn, String fitYn, String chkin, String chkout, String remrk) {
        this.hotelNo = hotelNo;
        this.hotelNm = hotelNm;
        this.hotelType = hotelType;
        this.location = location;
        this.grade = grade;
        this.breakfastYn = breakfastYn;
        this.parkYn = parkYn;
        this.swimYn = swimYn;
        this.fitYn = fitYn;
        this.chkin = chkin;
        this.chkout = chkout;
        this.remrk = remrk;
    }
}
