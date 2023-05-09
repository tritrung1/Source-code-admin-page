package com.training.entity;
import com.training.entity.dateaudit.DateAudit;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Set;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="account", uniqueConstraints = {
        @UniqueConstraint(name = "ACCOUNT_UK", columnNames = "account_name") })
public class Account extends DateAudit {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "account_ids")
    private Long id;

    @Column(name = "account_uuid")
    private String accountUuid;

    @Column(name = "account_img")
    private String accountImg;

    @Column(name = "account_img_path")
    private String accountImgPath;

    @Column(name = "banner_img")
    private String bannerImg;

    @Column(name = "banner_img_path")
    private String bannerImgPath;

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

    @Column(name = "password",length = 128, nullable = false)
    private String encryptedPassword;

//    private String roleName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", referencedColumnName = "role_ids")
    private Role role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @OneToMany(mappedBy = "account")
    private List<Notification> notifications;

    @OneToMany(mappedBy = "account")
    private List<Report> reports;

//    @OneToMany(mappedBy = "account")
//    Set<AccountRole> accountRole;

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountName='" + accountName + '\'' +
                ", accountEmail='" + accountEmail + '\'' +
                ", encryptedPassword='" + encryptedPassword + '\'' +
                '}';
    }
}
