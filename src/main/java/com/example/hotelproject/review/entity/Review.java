package com.example.hotelproject.review.entity;

import com.example.hotelproject.hotel.entity.Hotel;
import com.example.hotelproject.member.entity.Member;
import com.example.hotelproject.review.controller.request.ReviewUpdateRequest;
import com.example.hotelproject.util.entity.BaseDateTimeEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Entity(name = "review")
public class Review extends BaseDateTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq")
    private Long seq;

    @Column(name = "star_rate")
    private int starRate;

    @Column(name = "contents")
    private String contents;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_no")
    private Hotel hotel;

    @Builder
    public Review(Long seq, int starRate, String contents, Member member, Hotel hotel) {
        this.seq = seq;
        this.starRate = starRate;
        this.contents = contents;
        this.member = member;
        this.hotel = hotel;
    }

    public void update(ReviewUpdateRequest reviewUpdateRequest) { //TODO:request XX
        this.contents = reviewUpdateRequest.getContent();
        this.starRate = reviewUpdateRequest.getStarRate();
    }
}
