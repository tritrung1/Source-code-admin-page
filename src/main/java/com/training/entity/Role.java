package com.training.entity;
import com.training.entity.dateaudit.DateAudit;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="Role", uniqueConstraints = {
        @UniqueConstraint(name = "ROLE_UK", columnNames = "role_name") })
public class Role extends DateAudit {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "role_ids")
    private Long id;

    @Column(name = "role_uuid")
    private String roleUuid;

    @Column(name = "role_name")
    private String roleName;

    @OneToMany(mappedBy = "role")
    private List<Account> accounts;

//    @OneToMany(mappedBy = "role")
//    Set<AccountRole> accountRole;

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
