package com.productReview.productReview.services;

import com.productReview.productReview.dto.ReviewDto;
import com.productReview.productReview.models.Product;
import com.productReview.productReview.models.Review;


import java.util.List;

public interface ReviewService {

    public Review createReview ( ReviewDto reviewDto,Integer productId) throws Exception;

    public Product deleteReview (Integer productId, Integer reviewId)throws Exception;


    public List<Review> getAllReviewOfSingleProduct ( Integer productId) throws Exception;

}
