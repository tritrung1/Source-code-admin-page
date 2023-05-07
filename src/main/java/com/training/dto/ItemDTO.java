package com.training.dto;
import com.training.entity.Customer;

import com.training.entity.Product;
import com.training.entity.dateaudit.DateAudit;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ItemDTO extends DateAudit {
    private Long id;
    private Product product;
    private int quantity;
    private String code;
    private Customer customer;
}
