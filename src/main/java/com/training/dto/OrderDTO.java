package com.training.dto;

import com.training.entity.*;
import com.training.entity.dateaudit.DateAudit;
import lombok.*;

import javax.validation.constraints.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class OrderDTO extends DateAudit {

    private Long id;

    @NotEmpty(message = "Field can't be empty!")
    private String orderUuid;

    @NotEmpty(message = "Field can't be empty!")
    private String paymentMethod;

    private Double totalPrice;

    private DeliveryDetail deliveryDetail;

    private OrderStatus orderStatus;

    private Customer customer;

    private List<Feedback> feedback;

}
