package com.productReview.productReview.services;

import com.productReview.productReview.dto.ProductDto;
import com.productReview.productReview.models.Product;


import java.util.List;

public interface ProductService {

    public Product addNewProduct( ProductDto productDto);

    public List<Product> getAllProduct();

    public Product getProductById( Integer id) throws Exception;

    public Product updateProductById( ProductDto productDto,Integer id) throws Exception;


    public Product deleteProductById( Integer id) throws Exception;

}
