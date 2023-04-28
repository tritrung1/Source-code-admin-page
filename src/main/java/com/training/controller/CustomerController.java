package com.training.controller;

import com.training.consts.ApiPath;
import com.training.dto.CustomerDTO;
import com.training.servcie.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class CustomerController {

    @Autowired
    CustomerService service;

    @PostMapping(value = ApiPath.CUSTOMER_CREATE)
    public CustomerDTO newCustomer(@RequestBody CustomerDTO newCustomer) {
        return service.save(newCustomer);
    }

    @GetMapping(value = ApiPath.CUSTOMER_GET_ALL)
    public List<CustomerDTO> getAllCustomers() {
        return service.findAll();
    }

    @GetMapping(value = ApiPath.CUSTOMER_BY_ID)
    public CustomerDTO getCustomerById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping(value = ApiPath.CUSTOMER_UPDATE)
    public Integer updateCustomer(@RequestBody CustomerDTO newCustomer) {
        return service.update(newCustomer);
    }

    @DeleteMapping(value = ApiPath.CUSTOMER_DELETE)
    public String deleteCustomer(@RequestBody CustomerDTO newCustomer) {
        boolean isDelete = service.delete(newCustomer);
        return  isDelete ? "Delete success!!!" : "Delete fail!!!";
    }

}
