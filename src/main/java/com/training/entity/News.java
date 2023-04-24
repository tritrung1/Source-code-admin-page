package com.training.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "news")
public class News implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "push_id")
    private Long pushId;
    @Column(name = "push_code")
    private String pushCode;
    @Column(name = "push_date")
    private Date pushDate;
    @Column(name = "account_id")
    private Long accountId;
    @Column(name = "expired_date")
    private Date expiredDate;
    @Column(name = "product_id")
    private Long productId;
}
