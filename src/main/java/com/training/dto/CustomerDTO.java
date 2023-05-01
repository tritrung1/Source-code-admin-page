package com.training.dto;

import com.training.entity.Customer;
import com.training.entity.Order;
import com.training.entity.dateaudit.DateAudit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CustomerDTO extends DateAudit {

    private Long id;

    @NotEmpty(message = "Field can't be empty!")
    private String customerUuid;

    @NotEmpty(message = "Field can't be empty!")
    @Email(message = "Field must be a well-formed email address")
    private String customerEmail;

    @NotEmpty(message = "Field can't be empty!")
    private String password;

    @NotEmpty(message = "Field can't be empty!")
    @Size(min = 2, message = "Field should have at least 2 characters")
    private String firstName;

    @NotEmpty(message = "Field can't be empty!")
    @Size(min = 2, message = "Field should have at least 2 characters")
    private String lastName;

    @NotEmpty(message = "Field can't be empty!")
    @Size(min = 10, message = "Field should have at least 10 characters")
    private String customerPhone;

    @NotEmpty(message = "Field can't be empty!")
    private String customerAddress;

    @NotEmpty(message = "Field can't be empty!")
    private Boolean enabled;

    private List<Order> orders;

    private List<Customer> customers;

}
