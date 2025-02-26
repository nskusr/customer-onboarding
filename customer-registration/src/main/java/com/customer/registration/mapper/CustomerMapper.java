package com.customer.registration.mapper;

import com.customer.registration.dto.CustomerDTO;
import com.customer.registration.model.Customer;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(target = "id", ignore = true)
    Customer toEntity(CustomerDTO dto);

    @Mapping(target = "id", ignore = true)
    @IterableMapping(elementTargetType = CustomerDTO.class)
    List<CustomerDTO> toDTO(List<Customer> customers);
}
