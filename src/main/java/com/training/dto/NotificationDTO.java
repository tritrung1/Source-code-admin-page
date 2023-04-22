package com.training.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationDTO {
    private Long id;
    private Long notificationId;
    private String notificationCode;
    private Long accountId;
    private Long merchantId;
    private Long orderId;
    private Long postId;
    private String notificationType;
}
