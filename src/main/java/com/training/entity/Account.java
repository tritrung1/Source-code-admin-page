package com.training.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="Account")
public class Account implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "account_img")
    private String accountImg;

    @Column(name = "banner_img")
    private String bannerImg;

    @Column(name = "account_id")
    @GeneratedValue
    private UUID accountId;

    @Column(name = "merchant_id")
    private Long merchantId;

    @Column(name = "account_name")
    private String accountName;

    @Column(name = "account_email")
    private String accountEmail;

    @Column(name = "role_id")
    private Long roleId;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "modified_date")
    private Date modifiedDate;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "modified_by")
    private String modifiedBy;

//=======
//    @Column(name = "account_id")
//    @GeneratedValue(generator = "UUID")
//    @GenericGenerator(
//            name = "UUID",
//            strategy = "org.hibernate.id.UUIDGenerator"
//    )
//    private UUID account_id;
//    @Column(name = "merchant_id")
//    private Long merchant_id;
//    @Column(name = "role_id")
//    @GeneratedValue(generator = "UUID")
//    @GenericGenerator(
//            name = "UUID",
//            strategy = "org.hibernate.id.UUIDGenerator"
//    )
//    private UUID role_id; // add relationship to role_id
//    @Column(name = "name")
//    private String name;
//    @Column(name = "email")
//    private String email;
//    @Column(name = "phone")
//    private String phone;
//    @Column(name = "address")
//    private String address;
//    @Column(name = "account_img")
//    private String account_img;
//    @Column(name = "banner_img")
//    private String banner_img;
//    @Column(name = "active")
//    private Boolean active;
//    @Column(name = "created_date")
//    private String created_date;
//    @Column(name = "created_by")
//    private String created_by;
//    @Column(name = "modified_date")
//    private String modified_date;
//    @Column(name = "modified_by")
//    private String modified_by;
//>>>>>>> Stashed changes
}
