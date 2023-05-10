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

    private String orderStatusUuid;

    private String name;

    private List<Order> orders;

}
