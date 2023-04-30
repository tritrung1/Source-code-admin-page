package com.training.dto;
import com.training.entity.Product;
import com.training.entity.dateaudit.DateAudit;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PriceDTO extends DateAudit {
    private Long id;

    private String priceUuid;

    private String productCode;

    private Double price;

    private Integer discount;

    private Product product;
}
