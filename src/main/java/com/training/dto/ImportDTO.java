package com.training.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImportDTO implements Serializable {
    private Long id;
    private Integer importQuantity;
    private Date importDate;
    private Date createdDate;
    private Date modifiedDate;
    private String createdBy;
    private String modifiedBy;
}
