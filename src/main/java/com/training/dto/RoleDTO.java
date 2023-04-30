package com.training.dto;

import com.training.entity.Account;
import com.training.entity.dateaudit.DateAudit;
import lombok.*;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO extends DateAudit {
    private Long id;

    private String roleUuid;

    private String roleName;

    private List<Account> accounts;
}
