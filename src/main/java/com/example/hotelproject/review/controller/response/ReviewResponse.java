package com.example.hotelproject.review.controller.response;

import com.example.hotelproject.review.entity.Review;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReviewResponse {

    private String nickname;
    private String content;
    private int starRate;

    private LocalDateTime createdAt;

    @Builder
    public ReviewResponse(String nickname, String content, int starRate, LocalDateTime createdAt) {
        this.nickname = nickname;
        this.content = content;
        this.starRate = starRate;
        this.createdAt = createdAt;
    }

    public static ReviewResponse of(Review review) {
        return ReviewResponse.builder()
                .starRate(review.getStarRate())
                .content(review.getContents())
                .createdAt(review.getCreatedAt())
                .build();
    }
}
