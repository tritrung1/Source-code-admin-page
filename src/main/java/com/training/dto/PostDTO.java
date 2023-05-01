package com.training.dto;

import com.training.entity.Account;
import com.training.entity.Notification;
import com.training.entity.Product;
import com.training.entity.dateaudit.DateAudit;
import lombok.*;

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
    private String postUuid;
    private Date expiredDate;
    private String reason;
    private String status;;
    private Product product;
    private String accountID;
    private List<Notification> notifications;
}

