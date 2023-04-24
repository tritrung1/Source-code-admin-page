package com.training.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewsDTO {
    private Long id;
    private Long pushId;
    private String pushCode;
    private Date pushDate;
    private Long accountId;
    private Date expiredDate;
    private Long productId;
}
