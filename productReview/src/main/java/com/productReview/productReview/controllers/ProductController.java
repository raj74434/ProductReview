package com.productReview.productReview.controllers;

import com.productReview.productReview.dto.ProductDto;
import com.productReview.productReview.models.Product;
import com.productReview.productReview.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

//    Add a Product
    @PostMapping("/api/products")
     public ResponseEntity<Product> addNewProduct(@RequestBody ProductDto productDto){

        return new ResponseEntity<>( productService.addNewProduct(productDto), HttpStatus.CREATED);
     }



//    Read All Products
    @GetMapping("/api/products")
    public ResponseEntity<List<Product>> getAllProduct(){

        return new ResponseEntity<>(productService.getAllProduct(), HttpStatus.OK);
    }
//    Read Product by ID
    @GetMapping ("/api/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer id) throws Exception {

        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }
//    Update a Product
    @PutMapping("/api/products/{id}")
    public ResponseEntity<Product> updateProductById(@RequestBody ProductDto productDto,@PathVariable Integer id) throws Exception {

           return new ResponseEntity<>(productService.updateProductById(productDto,id), HttpStatus.CREATED);
    }
//    Delete a Product
    @DeleteMapping("/api/products/{id}")
    public ResponseEntity<Product> deleteProductById(@PathVariable Integer id) throws Exception {

           return new ResponseEntity<>(productService.deleteProductById(id), HttpStatus.CREATED);
    }


}
