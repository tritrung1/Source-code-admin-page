package com.training.dto;

import com.training.entity.*;
import com.training.entity.dateaudit.DateAudit;
import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.*;
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

    private List<Item> items;

    private Double totalPrice;

    private Long deliveryDetailId;

    private DeliveryDetail deliveryDetail;

    private Long orderStatusId;

    private OrderStatus orderStatus;

    private Customer customer;

    private List<Feedback> feedback;

}
