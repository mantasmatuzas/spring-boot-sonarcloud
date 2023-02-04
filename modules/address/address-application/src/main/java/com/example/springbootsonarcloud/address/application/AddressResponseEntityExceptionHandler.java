package com.example.springbootsonarcloud.address.application;

import com.example.springbootsonarcloud.address.application.usecase.UserAddressAlreadyExists;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class AddressResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserAddressAlreadyExists.class)
    ProblemDetail handle(UserAddressAlreadyExists ex) {
        var problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT, ex.getMessage());
        problemDetail.setTitle("User address already exists");
        problemDetail.setProperty("key", "user_address_already_exists");
        return problemDetail;
    }
}
