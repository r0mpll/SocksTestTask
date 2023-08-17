package com.example.sockstesttask.controllers;


import com.example.sockstesttask.exceptions.InvalidValuesException;
import com.example.sockstesttask.exceptions.UnknownOperationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(UnknownOperationException.class)
    public ResponseEntity<String> unknownOperation(UnknownOperationException e){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidValuesException.class)
    public ResponseEntity<String> invalidValues(InvalidValuesException e){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
    }
}
