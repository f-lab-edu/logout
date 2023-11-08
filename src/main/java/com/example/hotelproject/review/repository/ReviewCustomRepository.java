package com.example.hotelproject.review.repository;

import com.example.hotelproject.review.entity.Review;
import java.util.List;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public interface ReviewCustomRepository {

    PageImpl<Review> findAllContents(Pageable pageable, Long hotelNo);

    List<Integer> sumRate(Long hotelNo);

}
