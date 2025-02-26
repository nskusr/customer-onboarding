package com.customer.registration.service;
import com.customer.registration.dto.CustomerDTO;
import com.customer.registration.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CustomerService {
    void saveCustomer(CustomerDTO customer);
    List<CustomerDTO> getAllCustomers();
}
