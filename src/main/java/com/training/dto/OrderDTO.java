package com.training.dto;

import com.training.entity.*;
import com.training.entity.dateaudit.DateAudit;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class OrderDTO extends DateAudit {

    private Long id;

    private String orderUuid;

    private String orderCode;

    private String paymentMethod;

    private Double price;

    private Product product;

    private DeliveryDetail deliveryDetail;

    private OrderStatus orderStatus;

    private Customer customer;

    private List<Feedback> feedback;

}
