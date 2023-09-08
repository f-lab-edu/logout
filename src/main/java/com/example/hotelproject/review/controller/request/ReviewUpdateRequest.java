package com.example.hotelproject.review.controller.request;

import com.example.hotelproject.hotel.entity.Hotel;
import com.example.hotelproject.review.entity.Review;
import com.example.hotelproject.user.entity.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReviewUpdateRequest {
    private String userId;
    private Long hotelNo;
    private String content;
    private int starRate;

    private LocalDateTime createdAt;

    @Builder
    public ReviewUpdateRequest(String userId, Long hotelNo, String content, int starRate) {
        this.userId = userId;
        this.hotelNo = hotelNo;
        this.content = content;
        this.starRate = starRate;
    }

    public Review toReview(User user, Hotel hotel){
        return Review.builder()
                .user(user)
                .hotel(hotel)
                .contents(content)
                .starRate(starRate)
                .build();
    }
}
