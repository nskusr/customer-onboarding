package com.customer.registration.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CustomerDTO {

    @JsonIgnore
    private Long id;
    @NotBlank(message = "First Name cannot be empty")
    private String firstName;
    @NotBlank(message = "Last Name cannot be empty")
    private String lastName;
    @Past(message = "Date Of Birth cannot be future")
    private LocalDate dateOfBirth;
}
