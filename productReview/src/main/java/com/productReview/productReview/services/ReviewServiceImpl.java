package com.productReview.productReview.services;

import com.productReview.productReview.dto.ReviewDto;
import com.productReview.productReview.models.Product;
import com.productReview.productReview.models.Review;
import com.productReview.productReview.repository.ProductRepo;
import com.productReview.productReview.repository.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService{

    @Autowired
    private ReviewRepo reviewRepo;

    @Autowired
    private ProductRepo productRepo;

    @Override
    public Review createReview (ReviewDto reviewDto, Integer productId) throws Exception {
        Optional<Product> product=productRepo.findById(productId);
        if (product.isEmpty())  throw new Exception("No product availabe with this id "+productId);

        Review newReview=new Review();
        newReview.setCDate(LocalDateTime.now());
        newReview.setUDate(LocalDateTime.now());
        newReview.setDescription(reviewDto.getDescription());
        newReview.setUserId(reviewDto.getUserId());
        product.get().addSingleReview(newReview);
        productRepo.save(product.get());
        return newReview;

    }

    @Override
    public Product deleteReview(Integer productId, Integer reviewId) throws Exception {

        Optional<Product> product=productRepo.findById(productId);
        if (product.isEmpty())  throw new Exception("No product availabe with this id "+productId);

        Optional<Review> review=reviewRepo.findById(reviewId);
        if (review.isEmpty())  throw new Exception("No product availabe with this id "+productId);

       List<Review> allReviews=new ArrayList<>();
       for(int x=0;x<product.get().getReviews().size();x++){
           if(product.get().getReviews().get(x).getId()==reviewId){

           }
           else {
               allReviews.add(product.get().getReviews().get(x));
           }
       }

       product.get().setReviews(allReviews);

        productRepo.save(product.get());
        return product.get();
    }

    @Override
    public List<Review> getAllReviewOfSingleProduct(Integer productId) throws Exception {

        Optional<Product> product=productRepo.findById(productId);
        if (product.isEmpty())  throw new Exception("No product availabe with this id "+productId);


        return product.get().getReviews();
    }

}
