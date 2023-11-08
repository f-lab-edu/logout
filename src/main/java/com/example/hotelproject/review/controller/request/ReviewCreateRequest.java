package com.example.hotelproject.review.controller.request;

import com.example.hotelproject.hotel.entity.Hotel;
import com.example.hotelproject.member.entity.Member;
import com.example.hotelproject.review.entity.Review;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReviewCreateRequest {

    private String nickname;
    private String email;
    private Long hotelNo;
    private String content;
    private int starRate;

    @Builder
    public ReviewCreateRequest(String nickname, String email, Long hotelNo, String content,
            int starRate) {
        this.nickname = nickname;
        this.email = email;
        this.hotelNo = hotelNo;
        this.content = content;
        this.starRate = starRate;
    }

    public Review toReview(Member member, Hotel hotel) {
        return Review.builder()
                .member(member)
                .hotel(hotel)
                .contents(content)
                .starRate(starRate)
                .build();
    }
}
