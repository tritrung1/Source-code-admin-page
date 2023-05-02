package com.training.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @Column(name = "post_uuid")
    private String postUuid;

    @Column(name = "expired_date")
    private Date expiredDate;

    @Column(name = "reason")
    private String reason;

    @Column(name = "status")
    private String status;

    // one to one with table product
    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @JsonBackReference
    private Product product;


    @Column(name = "account_id")
    private String accountId;

    @OneToMany(mappedBy = "post")
    private List<Notification> notifications;
}
