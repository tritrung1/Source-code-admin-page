package com.training.dto;

import com.training.entity.Product;

import com.training.entity.dateaudit.DateAudit;
import lombok.*;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CategoryDTO extends DateAudit {
    private Long id;

    @NotEmpty(message = "Field can't be empty!")
    private String categoryUuid;

    @NotEmpty(message = "Field can't be empty!")
    @Size(min = 2, message = "Field should have at least 2 characters")
    private String categoryName;

    private List<Product> products;
}
