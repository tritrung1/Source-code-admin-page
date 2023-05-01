package com.training.dto;

import com.training.entity.Account;
import com.training.entity.Order;
import com.training.entity.Post;
import com.training.entity.dateaudit.DateAudit;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotificationDTO extends DateAudit {
    private Long id;

    @NotEmpty(message = "Field can't be empty!")
    private String notificationUuid;

    @NotEmpty(message = "Field can't be empty!")
    private String notificationCode;

    @NotNull(message = "Field can't be empty!")
    private Long merchantId;

    @NotNull(message = "Field can't be empty!")
    private Long postId;

    @NotEmpty(message = "Field can't be empty!")
    private String notificationType;

    private Account account;

    private Order order;

    private Post post;
}
