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

    private String deliveryDetailUuid;

    private Date deliveryDate;

    private String shippingUnit;

    private String shipperName;

    private String shipperPhone;

    private String shipperAddress;

    private List<OrderDTO> orders;

}
