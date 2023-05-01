package com.training.entity;

import lombok.*;
import com.training.entity.dateaudit.DateAudit;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
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

    @NotEmpty
    @Column(name = "post_id")
    @GeneratedValue
    private UUID postId;

    @NotEmpty
    @Column(name = "expired_date")
    private Date expiredDate;

    @NotNull
    @Column(name = "reason")
    private String reason;

    @NotEmpty
    @Column(name = "status")
    private String status;

    // one to one with table product
    @NotEmpty
    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @NotEmpty
    @Column(name = "account_id")
    private String accountID;

    @NotEmpty
    @OneToMany(mappedBy = "post")
    private List<Notification> notifications;
}
