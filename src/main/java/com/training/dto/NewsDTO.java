package com.training.dto;

import com.training.entity.Account;
import com.training.entity.Product;
import com.training.entity.dateaudit.DateAudit;
import lombok.*;

import java.io.Serializable;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewsDTO extends DateAudit {
    private Long id;

    private String newsUuid;

    private String pushCode;

    private Date pushDate;

    private Date expiredDate;

    private Account account;

    private Product product;
}
