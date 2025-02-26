package com.customer.registration.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import io.swagger.v3.oas.annotations.media.Schema;


import java.time.LocalDate;

@Entity
@Getter
@Setter
@Schema(description = "Customer entity representing user details")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique identifier for the customer", example = "1")
    private Long id;

    @Schema(description = "First name of the customer", example = "John")
    private String firstName;

    @Schema(description = "Last name of the customer", example = "Doe")
    private String lastName;

    @Schema(description = "Date of birth of the customer (YYYY-MM-DD)", example = "1990-01-01")
    private LocalDate dateOfBirth;

}
