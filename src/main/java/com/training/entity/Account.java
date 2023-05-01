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

    @NotEmpty
    @Column(name = "account_uuid")
    private String accountUuid;

    @NotEmpty
    @Column(name = "account_img")
    private String accountImg;

    @NotEmpty
    @Column(name = "banner_img")
    private String bannerImg;

    @NotNull
    @Column(name = "merchant_id")
    private Long merchantId;

    @NotEmpty
    @Size(min = 5)
    @Column(name = "account_name")
    private String accountName;

    @NotEmpty
    @Email
    @Column(name = "account_email")
    private String accountEmail;

    @NotEmpty
    @Size(min = 10)
    @Column(name = "phone")
    private String phone;

    @NotEmpty
    @Column(name = "address")
    private String address;

    @NotEmpty
    @Column(name = "active")
    private Boolean active;

    @NotEmpty
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;

    @NotEmpty
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @NotEmpty
    @OneToMany(mappedBy = "account")
    private List<Notification> notifications;

    @NotEmpty
    @OneToMany(mappedBy = "account")
    private List<Product> products;

    @NotEmpty
    @OneToMany(mappedBy = "account")
    private List<Report> reports;

    @NotEmpty
    @OneToMany(mappedBy = "account")
    private List<News> news;
}
