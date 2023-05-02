package com.training.entity;


import com.training.entity.dateaudit.DateAudit;
import lombok.*;

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

    @Column(name = "push_date")
    private Date pushDate;

    @Column(name = "expired_date")
    private Date expiredDate;

    @OneToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @Column(name = "account_id")
    private String accountId;

}
