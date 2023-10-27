package com.productReview.productReview.services;

import com.productReview.productReview.dto.ProductDto;
import com.productReview.productReview.models.Product;
import com.productReview.productReview.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements  ProductService{

    @Autowired
    private ProductRepo productRepo;

    @Override
    public Product addNewProduct(ProductDto productDto){
        Product productnew=new Product();
        productnew.setName(productDto.getName());
        productnew.setPrice(productDto.getPrice());
        productnew.setCDate(LocalDateTime.now());
        productnew.setUDate(LocalDateTime.now());
        return productRepo.save(productnew);

    }

    @Override
    public List<Product> getAllProduct(){

        return productRepo.findAll();
    }

    @Override
    public Product getProductById( Integer id) throws Exception {
        Optional<Product> product=productRepo.findById(id);
        if (product.isEmpty())  throw new Exception("No product availabe with this id "+id);
        return product.get();

    }


    @Override
    public Product updateProductById( ProductDto productDto, Integer id) throws Exception {

        Optional<Product> product=productRepo.findById(id);
        if (product.isEmpty())  throw new Exception("No product available with this id "+id);
        product.get().setPrice(productDto.getPrice());
        product.get().setName(productDto.getName());
        product.get().setUDate(LocalDateTime.now());
        productRepo.save(product.get());

        return product.get();

    }

    @Override
    public Product deleteProductById( Integer id) throws Exception {

        Optional<Product> product=productRepo.findById(id);
        if (product.isEmpty())  throw new Exception("No product available with this id "+id);
        productRepo.delete(product.get());
        return product.get();
    }




}
