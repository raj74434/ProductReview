package com.productReview.productReview.repository;

import com.productReview.productReview.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Integer> {



}
