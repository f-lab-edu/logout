package com.example.hotelproject.review.repository;

import com.example.hotelproject.review.entity.Review;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public interface ReviewCustomRepository {

    PageImpl<Review> findAllContents(Pageable pageable, Long hotelNo);

    Double getAverageRate(Long hotelNo);
}
