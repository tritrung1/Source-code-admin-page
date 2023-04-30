package com.training.dto;

import com.training.entity.*;
import com.training.entity.dateaudit.DateAudit;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO extends DateAudit {
    private Long id;

    private String productUuid;

    private String productImage;

    private String productName;

    private String productCode;

    private String description;

    private Double price;

    private String brand;

    private String color;

    private String size;

    private Integer importQuantity;

    private Category category;

    private Account account;

    private Post post;

    private Feedback feedback;

    private List<Price> prices;

    private List<Import> imports;

    private List<Order> orders;

    private List<News> news;
}
