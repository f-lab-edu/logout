package com.example.hotelproject.review.service;

import com.example.hotelproject.exception.CustomException;
import com.example.hotelproject.hotel.entity.Hotel;
import com.example.hotelproject.hotel.repository.HotelRepository;
import com.example.hotelproject.member.entity.Member;
import com.example.hotelproject.member.repository.MemberRepository;
import com.example.hotelproject.review.controller.request.PageRequest;
import com.example.hotelproject.review.controller.request.ReviewCreateRequest;
import com.example.hotelproject.review.controller.request.ReviewUpdateRequest;
import com.example.hotelproject.review.controller.response.ReviewResponse;
import com.example.hotelproject.review.entity.Review;
import com.example.hotelproject.review.repository.ReviewRepository;
import java.time.LocalDateTime;
import javax.persistence.EntityNotFoundException;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReviewService {

    private ReviewRepository reviewRepository;
    private MemberRepository memberRepository;
    private HotelRepository hotelRepository;

    public ReviewService(ReviewRepository reviewRepository, MemberRepository memberRepository,
            HotelRepository hotelRepository) {
        this.reviewRepository = reviewRepository;
        this.memberRepository = memberRepository;
        this.hotelRepository = hotelRepository;
    }

    public PageImpl<ReviewResponse> findAllContents(Long hotelNo, PageRequest pageRequest) {
        Pageable pageable = pageRequest.of();
        PageImpl<Review> reviews = reviewRepository.findAllContents(pageable, hotelNo);
        return (PageImpl<ReviewResponse>) reviews.map(ReviewResponse::of);
    }

    @Transactional
    public void create(ReviewCreateRequest reviewCreateRequest) {
        Member member = memberRepository.findMemberByEmail(reviewCreateRequest.getEmail())
                .orElseThrow(() -> new CustomException(
                        "no member with " + reviewCreateRequest.getEmail()));

        Hotel hotel = hotelRepository.findByHotelNo(reviewCreateRequest.getHotelNo())
                .orElseThrow(() -> new CustomException("no hotel"));
        ;

        Review review = reviewCreateRequest.toReview(member, hotel);
        reviewRepository.save(review);

        updateRate(reviewCreateRequest.getHotelNo());//TODO: test
    }

    @Transactional
    public void update(Long id, ReviewUpdateRequest reviewUpdateRequest) {
        //1.기한이 지난 리뷰는 수정이 불가(기한: 일주일로 설정)
        if (reviewUpdateRequest.getCreatedAt().plusWeeks(1).isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("일주일이 지난 리뷰는 수정이 불가합니다.");
        }

        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new CustomException("no review"));

        review.update(reviewUpdateRequest);

        updateRate(reviewUpdateRequest.getHotelNo());//TODO: test

    }

    //호텔 평균평점 업데이트
    public void updateRate(Long hotelNo) {
        Hotel hotel = hotelRepository.findByHotelNo(hotelNo)
                .orElseThrow(() -> new EntityNotFoundException("no hotel"));

        float avgRate = calculateRateAverge(hotel.getHotelNo());
        hotel.updateStarRateAverage(avgRate);
    }

    private float calculateRateAverge(Long hotelNo) {

        //리뷰 개수
        Integer cnt = reviewRepository.countByHotel_HotelNo(hotelNo);

        Integer sum = reviewRepository.sumRate(hotelNo).get(0);

        float avgRate = sum / cnt;

        //호텔 평균평점 업데이트
        return avgRate;
    }
}
