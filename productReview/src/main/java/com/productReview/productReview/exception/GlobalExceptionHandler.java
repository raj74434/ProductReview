package com.productReview.productReview.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MyErrorDetails> globalExceptionHandler(Exception ve, WebRequest wr){

        MyErrorDetails mrd= new MyErrorDetails();

        mrd.setTimestap(LocalDateTime.now());
        mrd.setMessage(ve.getMessage());
        mrd.setDetails(wr.getDescription(false));

        return new ResponseEntity<MyErrorDetails>(mrd, HttpStatus.BAD_REQUEST);
    }

}
