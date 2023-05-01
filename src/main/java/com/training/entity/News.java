package com.training.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.training.entity.dateaudit.DateAudit;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.sql.Date;
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

    @NotEmpty
    @Column(name = "news_uuid")
    private String newsUuid;

    @NotEmpty
    @Column(name = "push_code")
    private String pushCode;

    @NotEmpty
    @Column(name = "push_date")
    private Date pushDate;

    @NotEmpty
    @Column(name = "expired_date")
    private Date expiredDate;

    @NotEmpty
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    @NotEmpty
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;
}
