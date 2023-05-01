package com.training.entity;
import com.training.entity.dateaudit.DateAudit;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="Role")
public class Role extends DateAudit {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotEmpty
    @Column(name = "role_uuid")
    private String roleUuid;

    @NotEmpty
    @Size(min = 3)
    @Column(name = "role_name")
    private String roleName;

    @NotEmpty
    @OneToMany(mappedBy = "role")
    private List<Account> accounts;
}
