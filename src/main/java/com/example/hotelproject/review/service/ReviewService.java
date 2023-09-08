package com.example.hotelproject.review.service;

import com.example.hotelproject.exception.CustomException;
import com.example.hotelproject.hotel.entity.Hotel;
import com.example.hotelproject.hotel.repository.HotelRepository;
import com.example.hotelproject.review.controller.request.PageRequest;
import com.example.hotelproject.review.controller.request.ReviewCreateRequest;
import com.example.hotelproject.review.controller.request.ReviewUpdateRequest;
import com.example.hotelproject.review.controller.response.ReviewResponse;
import com.example.hotelproject.review.entity.Review;
import com.example.hotelproject.review.repository.ReviewRepository;
import com.example.hotelproject.user.entity.User;
import com.example.hotelproject.user.repository.UserRepository;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ReviewService {

    private ReviewRepository reviewRepository;
    private UserRepository userRepository;
    private HotelRepository hotelRepository;

    public ReviewService(ReviewRepository reviewRepository, UserRepository userRepository, HotelRepository hotelRepository) {
        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
        this.hotelRepository = hotelRepository;
    }

    public PageImpl<ReviewResponse> findAllContents(Long hotelNo, PageRequest pageRequest) {
        Pageable pageable = pageRequest.of();
        PageImpl<Review> reviews = reviewRepository.findAllContents(pageable, hotelNo);
        return (PageImpl<ReviewResponse>) reviews.map(ReviewResponse::of);
    }

    public void create(ReviewCreateRequest reviewCreateRequest) {
        User user = userRepository.findUserByUserId(reviewCreateRequest.getUserId())
                .orElseThrow(()-> new CustomException("no user"));

        Hotel hotel = hotelRepository.findByHotelNo(reviewCreateRequest.getHotelNo())
                .orElseThrow(()-> new CustomException("no hotel"));;

        Review review = reviewCreateRequest.toReview(user, hotel);
        reviewRepository.save(review);
    }

    public void update(Long id, ReviewUpdateRequest reviewUpdateRequest) {
        //1.기한이 지난 리뷰는 수정이 불가(기한: 일주일로 설정)
        if(reviewUpdateRequest.getCreatedAt().plusWeeks(1).isBefore(LocalDateTime.now())){
            throw new IllegalArgumentException("일주일이 지난 리뷰는 수정이 불가합니다.");
        }

        Review review = reviewRepository.findById(id)
                .orElseThrow(()-> new CustomException("no review"));

        review.update(reviewUpdateRequest);
    }
}
