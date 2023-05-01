package com.training.dto;

import com.training.entity.Product;
import com.training.entity.dateaudit.DateAudit;
import lombok.*;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ImportDTO extends DateAudit {
    private Long id;

    @NotEmpty(message = "Field can't be empty!")
    private String importUuid;

    @NotEmpty(message = "Field can't be empty!")
    private String productCode;

    @NotNull(message = "Field can't be null!")
    private Integer importQuantity;

    private Product product;
}
