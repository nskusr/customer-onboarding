package com.customer.registration.service;

import com.customer.registration.dto.CustomerDTO;
import com.customer.registration.mapper.CustomerMapper;
import com.customer.registration.model.Customer;
import com.customer.registration.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private CustomerRepository customerRepository;
    
    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        Customer customer = customerMapper.toEntity(customerDTO);
        customerRepository.save(customer);
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerMapper.toDTO(customerRepository.findAll());
    }
}
