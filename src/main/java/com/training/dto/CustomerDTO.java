package com.training.dto;

import com.training.entity.Customer;
import com.training.entity.Order;
import com.training.entity.dateaudit.DateAudit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CustomerDTO extends DateAudit {

    private Long id;

    private String customerUuid;

    private String customerEmail;

    private String password;

    private String firstName;

    private String lastName;

    private String customerPhone;

    private String customerAddress;

    private Boolean enabled;

    private List<Order> orders;

    private List<Customer> customers;

}
