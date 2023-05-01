package com.training.dto;

import com.training.entity.Account;
import com.training.entity.Notification;
import com.training.entity.Product;
import com.training.entity.dateaudit.DateAudit;
import lombok.*;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO extends DateAudit {
    private Long id;

    @NotEmpty(message = "Field can't be empty!")
    private String postUuid;

    @NotEmpty(message = "Field can't be empty!")
    private Date expiredDate;

    @NotNull(message = "Field can't be null!")
    private String reason;

    @NotEmpty(message = "Field can't be empty!")
    private String status;;

    private Product product;

    @NotEmpty(message = "Field can't be empty!")
    private String accountID;

    private List<Notification> notifications;
}

