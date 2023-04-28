package com.training.mapper;

import com.training.dto.OrderStatusDTO;
import com.training.entity.OrderStatus;
import org.springframework.stereotype.Service;

@Service
public class OrderStatusMapper extends AbstractMapper<OrderStatus, OrderStatusDTO> {
    public OrderStatusMapper() {
        super(OrderStatus.class, OrderStatusDTO.class);
    }
}
