package com.training.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceDTO implements Serializable {
    private Long id;
    private Double price;
    private Integer discount;
    private Date createdDate;
    private Date modifiedDate;
    private String createdBy;
    private String modifiedBy;
}
