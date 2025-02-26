package com.customer.registration.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {

    private Integer errorCode;
    private String errorMessage;
}
