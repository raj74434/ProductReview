package com.productReview.productReview.repository;

import com.productReview.productReview.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepo extends JpaRepository<Review,Integer> {
}
