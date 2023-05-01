package com.training.entity;

import com.training.entity.dateaudit.DateAudit;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customers")
public class Customer extends DateAudit {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotEmpty
    @Column(name = "customer_uuid")
    private String customerUuid;

    @NotEmpty
    @Email
    @Column(name = "customer_email")
    private String customerEmail;

    @NotEmpty
    @Column(name = "password")
    private String password;

    @NotEmpty
    @Size(min = 2)
    @Column(name = "first_name")
    private String firstName;

    @NotEmpty
    @Size(min = 2)
    @Column(name = "last_name")
    private String lastName;

    @NotEmpty
    @Size(min = 10)
    @Column(name = "customer_phone")
    private String customerPhone;

    @NotEmpty
    @Column(name = "customer_address")
    private String customerAddress;

    @NotEmpty
    @Column(name = "enabled")
    private Boolean enabled;

    @NotEmpty
    @OneToMany(mappedBy = "customer")
    private List<Order> orders;

    @NotEmpty
    @OneToMany(mappedBy = "customer")
    private List<Feedback> customers;

}
