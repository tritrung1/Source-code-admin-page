package com.training.dto;

import com.training.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewsDTO implements Serializable {
    private Long id;
    private String pushCode;
    private Date pushDate;
    private Long accountId;
    private Date expiredDate;
    private java.util.Date createdDate;
    private java.util.Date modifiedDate;
    private String createdBy;
    private String modifiedBy;
    private Product product;
}
