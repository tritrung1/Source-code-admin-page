package com.training.entity;

import lombok.*;
import com.training.entity.dateaudit.DateAudit;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "post")
public class Post extends DateAudit {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "post_id")
    @GeneratedValue
    private UUID postId;

    @Column(name = "expired_date")
    private Date expiredDate;

    @Column(name = "reason")
    private String reason;

    @Column(name = "status")
    private String status;

    // one to one with table product
    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @Column(name = "account_id")
    private String accountID;

    @OneToMany(mappedBy = "post")
    private List<Notification> notifications;
}
