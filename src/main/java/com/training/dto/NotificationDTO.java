package com.training.dto;

import com.training.entity.Account;
import com.training.entity.Order;
import com.training.entity.Post;
import com.training.entity.dateaudit.DateAudit;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotificationDTO extends DateAudit {
    private Long id;

    private String notificationUuid;

    private String notificationCode;

    private Long merchantId;

    private Long postId;

    private String notificationType;

    private Account account;

    private Order order;

    private Post post;
}
