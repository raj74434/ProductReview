package com.productReview.productReview.exception;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MyErrorDetails {

    private LocalDateTime timestap;
    private String message;
    private String details;

}
