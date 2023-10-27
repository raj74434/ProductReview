package com.productReview.productReview.controllers;

import com.productReview.productReview.dto.ReviewDto;
import com.productReview.productReview.models.Product;
import com.productReview.productReview.models.Review;
import com.productReview.productReview.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

//    Create a Review for a Product
    @PostMapping("/api/products/{productId}/reviews")
    public ResponseEntity<Review> createReview (@RequestBody ReviewDto reviewDto,
                                                @PathVariable  Integer productId) throws Exception {
        return new ResponseEntity<>(reviewService.createReview(reviewDto,productId), HttpStatus.CREATED);
    }



//    Delete a Review
    @DeleteMapping("/api/products/{productId}/reviews/{reviewId}")
    public ResponseEntity<Product> deleteReview (@PathVariable Integer productId, Integer reviewId) throws Exception {
        return new ResponseEntity<>(reviewService.deleteReview(productId,reviewId), HttpStatus.ACCEPTED);
    }






//    Virtual Population of Reviews for a Product
    @GetMapping("/api/products/{productId}/reviews")
    public ResponseEntity<List<Review>> getAllReviewOfSingleProduct (@PathVariable Integer productId) throws Exception {
       return new ResponseEntity<>(reviewService.getAllReviewOfSingleProduct(productId),HttpStatus.OK);
    }

}
