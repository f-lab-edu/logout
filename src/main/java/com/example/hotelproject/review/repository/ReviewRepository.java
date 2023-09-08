package com.example.hotelproject.review.repository;

import com.example.hotelproject.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewCustomRepository {
    Review save(Review review);
}
