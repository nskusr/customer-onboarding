package com.customer.registration.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerErrorResponse {

  private String fieldName;
  private String errorMessage;

}
