package com.customer.registration.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class CustomerExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<CustomerErrorResponse>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<CustomerErrorResponse> errorResponseList = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            CustomerErrorResponse response = new CustomerErrorResponse();
            response.setFieldName(((FieldError) error).getField());
            response.setErrorMessage(error.getDefaultMessage());
            errorResponseList.add(response);
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponseList);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode(500);
        errorResponse.setErrorMessage(ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
}
