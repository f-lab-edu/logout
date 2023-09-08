package com.example.hotelproject.review.controller;

import com.example.hotelproject.review.controller.request.PageRequest;
import com.example.hotelproject.review.controller.request.ReviewCreateRequest;
import com.example.hotelproject.review.controller.request.ReviewUpdateRequest;
import com.example.hotelproject.review.controller.response.ReviewResponse;
import com.example.hotelproject.review.service.ReviewService;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.PageImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/{hotelNo}")
    public PageImpl<ReviewResponse> findAll(@PathVariable("hotelNo") Long hotelNo, PageRequest pageRequest){
        return reviewService.findAllContents(hotelNo, pageRequest);
    }

    @PostMapping
    @ApiOperation(value = "리뷰 작성", notes = "호텔에 대한 리뷰를 생성합니다.")
    public void create(@RequestBody ReviewCreateRequest reviewCreateRequest){
        reviewService.create(reviewCreateRequest);
    }

    @PostMapping("/{id}")
    @ApiOperation(value = "리뷰 수정", notes = "리뷰를 수정합니다.")
    public void update(@PathVariable Long id, @RequestBody ReviewUpdateRequest reviewUpdateRequest){
        reviewService.update(id, reviewUpdateRequest);
    }
}
