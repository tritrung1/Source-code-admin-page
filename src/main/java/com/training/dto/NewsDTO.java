package com.training.dto;

import com.training.entity.Account;
import com.training.entity.Post;
import com.training.entity.Product;
import com.training.entity.dateaudit.DateAudit;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewsDTO extends DateAudit {
    private Long id;

    @NotEmpty(message = "Field can't be empty!")
    private String newsUuid;

    private Integer storageQuantity;

    private Double sales;

    private Date pushDate;

    private Date beginDate;

    private Date endDate;

    private Date expiredDate;

    private Post post;

    private String accountName;

}
