package com.training.entity;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "notification")
public class Notification implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "notification_id")
    private Long notificationId;
    @Column(name = "notification_code")
    private String notificationCode;
    @Column(name = "account_id")
    private Long accountId;
    @Column(name = "merchant_id")
    private Long merchantId;
    @Column(name = "order_id")
    private Long orderId;
    @Column(name = "post_id")
    private Long postId;
    @Column(name = "notification_type")
    private String notificationType;
}
