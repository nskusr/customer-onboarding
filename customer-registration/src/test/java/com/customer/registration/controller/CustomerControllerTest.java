package com.customer.registration.controller;

import com.customer.registration.dto.CustomerDTO;
import com.customer.registration.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class CustomerControllerTest {

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createCustomer_createsCustomerSuccessfully() {
        CustomerDTO customer = new CustomerDTO();
        ResponseEntity<?> response = customerController.createCustomer(customer);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(customer, response.getBody());
        verify(customerService, times(1)).saveCustomer(customer);
    }

    @Test
    void getCustomers_returnsListOfCustomers() {
        List<CustomerDTO> customers = List.of(new CustomerDTO());
        when(customerService.getAllCustomers()).thenReturn(customers);

        ResponseEntity<List<CustomerDTO>> response = customerController.getCustomers();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(customers, response.getBody());
        verify(customerService, times(1)).getAllCustomers();
    }

    @Test
    void getCustomers_returnsEmptyListWhenNoCustomers() {
        when(customerService.getAllCustomers()).thenReturn(Collections.emptyList());

        ResponseEntity<List<CustomerDTO>> response = customerController.getCustomers();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(Collections.emptyList(), response.getBody());
        verify(customerService, times(1)).getAllCustomers();
    }
}
