package com.training.dto;

import com.training.entity.*;
import com.training.entity.dateaudit.DateAudit;
import lombok.*;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO extends DateAudit {
    private Long id;

    @NotEmpty(message = "Field can't be empty!")
    private String productUuid;

    @NotEmpty(message = "Field can't be empty!")
    private String productImage;

    @NotEmpty(message = "Field can't be empty!")
    private String productName;

    @NotEmpty(message = "Field can't be empty!")
    private String productCode;

    @NotNull(message = "Field can't be null!")
    private String description;

    @NotNull(message = "Field can't be null!")
    private Double price;

    @NotEmpty(message = "Field can't be empty!")
    private String brand;

    @NotEmpty(message = "Field can't be empty!")
    private String color;

    @NotEmpty(message = "Field can't be empty!")
    private String size;

    @NotNull(message = "Field can't be null!")
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
