package com.training.dto;

import com.training.entity.dateaudit.DateAudit;
import lombok.*;

import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class DeliveryDetailDTO extends DateAudit {

    private Long id;

    @NotEmpty(message = "Field can't be empty!")
    private String deliveryDetailUuid;

    @NotEmpty(message = "Field can't be empty!")
    private Date deliveryDate;

    @NotEmpty(message = "Field can't be empty!")
    private String shippingUnit;

    @NotEmpty(message = "Field can't be empty!")
    @Size(min = 5, message = "Field should have at least 5 characters")
    private String shipperName;

    @NotEmpty(message = "Field can't be empty!")
    @Size(min = 10, message = "Field should have at least 10 characters")
    private String shipperPhone;

    @NotEmpty(message = "Field can't be empty!")
    private String shipperAddress;

    private List<OrderDTO> orders;

}
