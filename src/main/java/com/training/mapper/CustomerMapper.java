package com.training.mapper;

import com.training.dto.CustomerDTO;
import com.training.entity.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper extends AbstractMapper<Customer, CustomerDTO> {
    public CustomerMapper() {
        super(Customer.class, CustomerDTO.class);
    }
}
