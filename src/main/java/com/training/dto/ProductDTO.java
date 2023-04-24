package com.training.dto;

import com.training.entity.Category;
import com.training.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO implements Serializable {
    private Long id;
    private String productImage;
    private String productName;
    private String productCode;
    private String description;
    private Double price;
    private String brand;
    private String color;
    private String size;
    private Integer importQuantity;
    private Date createdDate;
    private Date modifiedDate;
    private String createdBy;
    private String modifiedBy;
    private Category category;
    private Post post;
}
