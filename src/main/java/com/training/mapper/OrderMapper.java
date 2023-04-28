package com.training.mapper;

import com.training.dto.OrderDTO;
import com.training.entity.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderMapper extends AbstractMapper<Order, OrderDTO> {
    public OrderMapper() {
        super(Order.class, OrderDTO.class);
    }
}
