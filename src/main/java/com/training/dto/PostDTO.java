package com.training.dto;

import com.training.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO implements Serializable {
    private Long id;
    private UUID postId;
    private Date expiredDate;
    private String reason;
    private Boolean active;
    private Date createdDate;
    private Date modifiedDate;
    private String createdBy;
    private String modifiedBy;
    private Product product;
}
