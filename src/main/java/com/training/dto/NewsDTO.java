package com.training.dto;

import com.training.entity.Account;
import com.training.entity.Product;
import com.training.entity.dateaudit.DateAudit;
import lombok.*;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewsDTO extends DateAudit {
    private Long id;

    @NotEmpty(message = "Field can't be empty!")
    private String newsUuid;

    @NotEmpty(message = "Field can't be empty!")
    private String pushCode;

    @NotEmpty(message = "Field can't be empty!")
    private Date pushDate;

    @NotEmpty(message = "Field can't be empty!")
    private Date expiredDate;

    private Account account;

    private Product product;
}
