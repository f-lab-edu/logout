package com.example.hotelproject.review.entity;

import com.example.hotelproject.hotel.entity.Hotel;
import com.example.hotelproject.review.controller.request.ReviewUpdateRequest;
import com.example.hotelproject.user.entity.User;
import com.example.hotelproject.util.entity.BaseDateTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

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
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_no")
    private Hotel hotel;

    @Builder
    public Review(Long seq, int starRate, String contents, User user, Hotel hotel) {
        this.seq = seq;
        this.starRate = starRate;
        this.contents = contents;
        this.user = user;
        this.hotel = hotel;
    }

    public void update(ReviewUpdateRequest reviewUpdateRequest){
        this.contents = reviewUpdateRequest.getContent();
        this.starRate = reviewUpdateRequest.getStarRate();
    }
}
