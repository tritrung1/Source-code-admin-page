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
public class ImportDTO extends DateAudit {
    private Long id;

    private String importUuid;

    private String productCode;

    private Integer importQuantity;

    private Product product;
}
