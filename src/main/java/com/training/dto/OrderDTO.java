package com.training.dto;

import com.training.entity.Customer;
import com.training.entity.DeliveryDetail;
import com.training.entity.Feedback;
import com.training.entity.OrderStatus;
import com.training.entity.dateaudit.DateAudit;
import lombok.*;

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

    private String productId;

    private DeliveryDetail deliveryDetail;

    private OrderStatus orderStatus;

    private Feedback feedback;

    private Customer customer;

}
