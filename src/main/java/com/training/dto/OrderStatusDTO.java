package com.training.dto;

import com.training.entity.Order;
import com.training.entity.dateaudit.DateAudit;
import lombok.*;

import javax.validation.constraints.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class OrderStatusDTO extends DateAudit {

    private Long id;

    @NotEmpty(message = "Field can't be empty!")
    private String orderStatusUuid;

    @NotEmpty(message = "Field can't be empty!")
    @Size(min = 2, message = "Field should have at least 2 characters")
    private String name;

    private List<Order> orders;

}
