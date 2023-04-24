package com.training.dto;

import com.training.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CategoryDTO implements Serializable {
    private Long id;
    private UUID categoryId;
    private String categoryName;
    private Date createdDate;
    private Date modifiedDate;
    private String createdBy;
    private String modifiedBy;
//    private Set<Product> products;
}
