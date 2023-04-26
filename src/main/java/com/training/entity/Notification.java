package com.training.entity;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

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
    @GeneratedValue
    private UUID notificationId;

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

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "modified_date")
    private Date modifiedDate;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "modified_by")
    private String modifiedBy;
}
