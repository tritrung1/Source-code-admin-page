package com.training.dto;
import com.training.entity.Customer;

import com.training.entity.Order;
import com.training.entity.Product;
import com.training.entity.dateaudit.DateAudit;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO extends DateAudit {
    private Long id;
    private String itemUuid;
    private Product product;
    private Integer quantity;
    private Order order;
}
