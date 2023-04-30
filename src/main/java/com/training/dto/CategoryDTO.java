package com.training.dto;

import com.training.entity.Product;

import com.training.entity.dateaudit.DateAudit;
import lombok.*;

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

    private String categoryUuid;

    private String categoryName;

    private List<Product> products;
}
