package com.training.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Account_Role", uniqueConstraints = {
        @UniqueConstraint(name = "ACCOUNT_ROLE_UK", columnNames = {"account_ids", "role_ids"}) })
public class AccountRole {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_ids", nullable = false)
    private Account account;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_ids", nullable = false)
    private Role role;

}
