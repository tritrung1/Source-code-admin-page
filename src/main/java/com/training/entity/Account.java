package com.training.entity;
import com.training.entity.dateaudit.DateAudit;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="account")
public class Account extends DateAudit {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "account_uuid")
    private String accountUuid;

    @Column(name = "account_img")
    private String accountImg;

    @Column(name = "banner_img")
    private String bannerImg;

    @Column(name = "merchant_id")
    private Long merchantId;

    @Column(name = "account_name")
    private String accountName;

    @Column(name = "account_email")
    private String accountEmail;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "active")
    private Boolean active;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @OneToMany(mappedBy = "account")
    private List<Notification> notifications;

    @OneToMany(mappedBy = "account")
    private List<Product> products;

    @OneToMany(mappedBy = "account")
    private List<Report> reports;

}
