package com.example.hotelproject.review.controller.response;

import com.example.hotelproject.review.entity.Review;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReviewResponse {
    private String content;
    private int starRate;

    private LocalDateTime createdAt;

    @Builder
    public ReviewResponse(String content, int starRate, LocalDateTime createdAt) {
        this.content = content;
        this.starRate = starRate;
        this.createdAt = createdAt;
    }

    public static ReviewResponse of(Review review){
        return ReviewResponse.builder()
                .starRate(review.getStarRate())
                .content(review.getContents())
                .createdAt(review.getCreatedAt())
                .build();
    }
}
