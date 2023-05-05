package com.training.entity;


import com.training.entity.dateaudit.DateAudit;
import lombok.*;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "news")
public class News extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "news_uuid")
    private String newsUuid;

    @Column(name = "storage_quantity")
    private Integer storageQuantity;

    @Column(name = "sales")
    private Double sales;

    @Column(name = "push_date")
    private Date pushDate;

    @Column(name = "sold_date")
    private Date soldDate;

    @Column(name = "expired_date")
    private Date expiredDate;

    @OneToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(name = "account_id")
    private String accountId;

}
